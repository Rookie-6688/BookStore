package com.book.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.common.valid.AddGroup;
import com.common.valid.DelGroup;
import com.common.valid.EmptyString;
import com.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:01:20
 */
@Data
@TableName("t_book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class,DelGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String bid;
	/**
	 * 
	 */
	@EmptyString(message = "书名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "书名不能为空",groups = {AddGroup.class})
	private String bname;

	@NotBlank(message = "URL不能为空",groups = {AddGroup.class})
	@URL(message = "url必须是一个合法的url地址",groups = {AddGroup.class,DelGroup.class,UpdateGroup.class})
	private String url;
	/**
	 * 
	 */
	@EmptyString(message = "作者名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "作者名不能为空",groups = {AddGroup.class})
	private String author;
	/**
	 * 
	 */
	@NotBlank(message = "价格不能为空",groups = {AddGroup.class})
	@Min(value = 1,groups = {AddGroup.class,DecimalMin.class,UpdateGroup.class})
	private BigDecimal price;
	/**
	 * 
	 *
	 */
	@EmptyString(message = "出版社不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "出版社不能为空",groups = {AddGroup.class})
	private String press;
	/**
	 * 
	 */
	@EmptyString(message = "出版日期不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "出版日期不能为空",groups = {AddGroup.class})
//	@Past(message = "出版日期必须为过去的时间",groups = {AddGroup.class,UpdateGroup.class})	因为数据库是char类型，这里就不改了
	private String publishtime;
	/**
	 *
	 */
//	@Pattern(regexp = "^[1-9]//d*$",message = "总字数必须为正整数",groups = {AddGroup.class,UpdateGroup.class})	只能判断String类型
	@NotBlank(message = "总字数不能为空",groups = {AddGroup.class})
	@Min(value = 1,groups = {AddGroup.class,UpdateGroup.class})
	private Integer wordnum;
	/**
	 * 
	 */
//	@Past(message = "印刷日期必须为过去的时间",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "印刷日期不能为空",groups = {AddGroup.class})
	@EmptyString(message = "印刷日期不能为空字符串",groups = {UpdateGroup.class})
	private String printtime;
	/**
	 * 
	 */
	@EmptyString(message = "分类ID不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "分类ID不能为空",groups = {AddGroup.class})
	private String cid;
	/**
	 * 
	 */
	@Min(value = 0,message = "排序字段必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "排序字段不能为空",groups = {AddGroup.class})
	private Integer orderby;

}
