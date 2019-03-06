/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.kcloud.umc.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色id", example = "1")
	@TableId(value = "role_id", type = IdType.AUTO)
	private Integer roleId;

	@ApiModelProperty(value = "角色名称", example = "domain_admin")
	@NotBlank(message = "{validation.role.name}")
	private String roleName;

	@ApiModelProperty(value = "角色code", example = "domain_code")
	@NotBlank(message = "{validation.role.code}")
	private String roleCode;

	@ApiModelProperty(value = "角色描述", example = "企业域管理员")
	@NotBlank(message = "{validation.role.desc}")
	private String roleDesc;

	@ApiModelProperty(value = "数据权限类型", example = "1")
//	@NotNull(message = "{validation.role.ds_type}")
	private Integer dsType;

	@ApiModelProperty(value = "数据权限范围", example = "2")
	private String dsScope;


	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	/**
	 * 删除标识（0-正常,1-删除）
	 */
	@TableLogic
	private String delFlag;

	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

}
