package com.book.service.impl;

import com.book.feign.CategoryFeign;
import com.book.feign.OrderItemFeignService;
import com.book.to.OrderItemTo;
import com.book.vo.BookVo;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.common.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.book.dao.BookDao;
import com.book.entity.BookEntity;
import com.book.service.BookService;


@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, BookEntity> implements BookService {
    @Autowired
    OrderItemFeignService orderItemFeignService;
    @Autowired
    CategoryFeign categoryFeign;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BookEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("bname",key).or((query)->{
                query.like("author",key);
            });
        }
        IPage<BookEntity> page = this.page(
                new Query<BookEntity>().getPage(params),
                bookEntityQueryWrapper
        );
        List<BookEntity> records = page.getRecords();
        List<BookVo> collect = records.stream().map(record -> {
            BookVo vo = new BookVo();
            BeanUtils.copyProperties(record, vo);
            String name = categoryFeign.getName(vo.getCid());
            vo.setCname(name);
            return vo;
        }).collect(Collectors.toList());
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);
        return pageUtils;
    }

    @Override
    public void updateCid(String cid) {
        List<BookEntity> cid1 = this.baseMapper.selectList(new QueryWrapper<BookEntity>().eq("cid", cid));
        if(cid1!=null&&cid1.size()>0){
            for (BookEntity bookEntity : cid1) {
                bookEntity.setCid("无");
                this.updateById(bookEntity);
            }
        }
    }

    @Override
    public String getBName(String bid) {
        BookEntity bookEntity = this.getById(bid);
        if(bookEntity!=null){
            return bookEntity.getBname();
        }else{
            return null;
        }

    }

    @Override
    public void update(BookEntity book) {
        BookEntity bookEntity = this.getById(book);
        if(bookEntity!=null&&(!bookEntity.getBname().equals(book.getBname()))){
            OrderItemTo to=new OrderItemTo();
            to.setBid(book.getBid());
            to.setBname(book.getBname());
            orderItemFeignService.updateBName(to);
        }
        this.updateById(book);
    }
}