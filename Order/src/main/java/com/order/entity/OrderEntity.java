package com.order.entity;

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
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:56:26
 */
@Data
@TableName("t_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String oid;
	/**
	 * 
	 */
	@EmptyString(message = "订单时间不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "订单时间不能为空",groups = {AddGroup.class})
	private String ordertime;
	/**
	 * 
	 */
	@Min(value = 0,message = "总价格必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "总价格不能为空",groups = {AddGroup.class})
	private BigDecimal total;
	/**
	 * 
	 */
	@Range(min = 0,max = 5,message = "状态必须在0-5之间（包含边界）",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "状态字段不能为空",groups = {AddGroup.class})
	private Integer status;
	/**
	 * 
	 */
	@EmptyString(message = "地址不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "地址不能为空",groups = {AddGroup.class})
	private String address;
	/**
	 * 
	 */
	@EmptyString(message = "uid不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "uid不能为空",groups = {AddGroup.class})
	private String uid;

}
