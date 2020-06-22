package com.cartitem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
 * @date 2020-05-28 15:59:28
 */
@Data
@TableName("t_cartitem")
public class CartitemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String cartitemid;
	/**
	 * 
	 */
	@NotBlank(message = "总字数不能为空",groups = {AddGroup.class})
	@Min(value = 1,groups = {AddGroup.class,UpdateGroup.class})
	private Integer quantity;
	/**
	 * 
	 */
	@EmptyString(message = "印刷日期不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "印刷日期不能为空",groups = {AddGroup.class})
	private String bid;
	/**
	 * 
	 */
	@EmptyString(message = "uid不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "uid不能为空",groups = {AddGroup.class})
	private String uid;
	/**
	 * 
	 */
	@Min(value = 0,message = "排序字段必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "排序字段不能为空",groups = {AddGroup.class})
	private Integer orderby;

}
