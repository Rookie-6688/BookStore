package com.category.entity;

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
 * @date 2020-05-28 15:57:21
 */
@Data
@TableName("t_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String cid;
	/**
	 * 
	 */
	@EmptyString(message = "分类名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "分类名不能为空",groups = {AddGroup.class})
	private String cname;
	/**
	 * 
	 */
	/**
	 * 
	 */
	@EmptyString(message = "描述不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "描述不能为空",groups = {AddGroup.class})
	private String desc1;
	/**
	 * 
	 */
	@Min(value = 0,message = "排序字段必须为大于等于0的数字",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "排序字段不能为空",groups = {AddGroup.class})
	private Integer orderby1;

}
