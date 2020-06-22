package com.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.common.valid.AddGroup;
import com.common.valid.DelGroup;
import com.common.valid.EmptyString;
import com.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:51:58
 */
@Data
@TableName("t_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotBlank(message = "id不能为空",groups = {UpdateGroup.class})
	@Null(message = "添加操作不能指定id",groups = {AddGroup.class})
	private String uid;
	/**
	 * 
	 */
	@EmptyString(message = "登录名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "登录名不能为空",groups = {AddGroup.class})
	private String loginname;
	/**
	 * 
	 */
	@EmptyString(message = "登录名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "登录名不能为空",groups = {AddGroup.class})
	private String loginpass;
	/**
	 * 
	 */
	@Email(message = "email格式不正确",groups = {UpdateGroup.class,AddGroup.class})
	@NotBlank(message = "email不能为空",groups = {AddGroup.class})
	private String email;
	/**
	 * 
	 */
	@Range(min = 0,max = 1,message = "状态必须在0-1之间（包含边界）",groups = {AddGroup.class,UpdateGroup.class})
	@NotBlank(message = "状态字段不能为空",groups = {AddGroup.class})
	private Integer status;
	/**
	 * 
	 */
	@EmptyString(message = "激活码不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "激活码不能为空",groups = {AddGroup.class})
	private String activationcode;

}
