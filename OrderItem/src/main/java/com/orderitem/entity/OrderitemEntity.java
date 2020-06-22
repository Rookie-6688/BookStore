package com.orderitem.entity;

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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:54:29
 */
@Data
@TableName("t_orderitem")
public class OrderitemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String orderitemid;
	/**
	 * 
	 */
	@Min(value = 1,message = "数量必须为大于等于1的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "数量不能为空",groups = {AddGroup.class})
	private Integer quantity;
	/**
	 * 
	 */
	@Min(value = 0,message = "总价格必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "总价格不能为空",groups = {AddGroup.class})
	private BigDecimal subtotal;
	/**
	 * 
	 */
	@EmptyString(message = "bid不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "bid不能为空",groups = {AddGroup.class})
	private String bid;
	/**
	 * 
	 */
	@EmptyString(message = "书名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "书名不能为空",groups = {AddGroup.class})
	private String bname;
	/**
	 * 
	 */
	@Min(value = 0,message = "单价必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "单价不能为空",groups = {AddGroup.class})
	private BigDecimal currprice;
	/**
	 * 
	 */
	/**
	 * 
	 */
	@EmptyString(message = "oid不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "oid不能为空",groups = {AddGroup.class})
	private String oid;

}
