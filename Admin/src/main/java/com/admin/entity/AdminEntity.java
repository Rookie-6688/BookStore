package com.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.common.valid.AddGroup;
import com.common.valid.DelGroup;
import com.common.valid.EmptyString;
import com.common.valid.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:02:24
 */
@Data
@TableName("t_admin")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@NotBlank(message = "ID不能为空",groups = {UpdateGroup.class,DelGroup.class})
	@Null(message = "新增不能指定ID",groups = {AddGroup.class})
	@TableId
	private String adminid;
	/**
	 * 
	 */
	@EmptyString(message = "姓名不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "姓名不能为空",groups = {AddGroup.class})
	private String adminname;
	/**
	 * 
	 */
	@EmptyString(message = "密码不能为空字符串",groups = {UpdateGroup.class})
	@NotBlank(message = "密码不能为空",groups = {AddGroup.class})
	private String adminpwd;

}
