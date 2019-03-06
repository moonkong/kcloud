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
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author
 * @since 2019-1-9
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "user_id", type = IdType.AUTO)
	private Integer userId;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名(请使用邮箱@前缀，请保持唯一)", example = "zhangsan")
	@NotBlank(message = "{validation.user.username}")
	@Size(max = 50, message = "{validation.user.username.size}")
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码", example = "password")
	@NotBlank(message = "{validation.user.password}")
	@Size(min = 4, max = 50, message = "{validation.user.password.size}")
	private String password;
	/**
	 * 随机盐
	 */
	@JsonIgnore
	private String salt;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 0-正常，1-删除
	 */
	@TableLogic
	private String delFlag;

	/**
	 * 锁定标记
	 */
	@ApiModelProperty(value = "锁定标记(0-正常，9-锁定)", example = "0")
	private String lockFlag;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号", example = "15500000000")
	@NotBlank(message = "{validation.user.phone}")
	@Size(max = 11, message = "{validation.user.phone.size}")
	private String phone;
	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像", example = "http://xxxxxx.png")
	private String avatar;

	/**
	 * 部门ID
	 */
	@ApiModelProperty(value = "部门ID", example = "1")
	private Integer deptId;

	/**
	 * 微信openid
	 */
	private String wxOpenid;

	/**
	 * 钉钉 openid
	 */
	private String ddOpenid;

	/**
	 * 租户ID
	 */
	private Integer tenantId;

	/**
	 * 中文名
	 */
	@ApiModelProperty(value = "中文名", example = "张三")
	private String realName;

	/**
	 * 英文名
	 */
	@ApiModelProperty(value = "英文名", example = "zhangsan")
	private String realNameEn;

	/**
	 * 姓
	 */
	private String firstName;

	/**
	 * 名
	 */
	private String lastName;

	/**
	 * 姓名拼音
	 */
	@ApiModelProperty(value = "姓名拼音", example = "zhangsan")
	private String namePinyin;

	/**
	 * 姓名拼音长度（记录每个音节长度，英文逗号分隔，如“张三”是“5,3”）
	 */
	private String namePinyinLen;

	/**
	 * 姓名拼音缩写（记录每个音节首字母，如“张三”是“zs”）
	 */
	private String namePinyinShort;

	/**
	 * 性别（0女 / 1男）
	 */
	@ApiModelProperty(value = "性别（0女 / 1男）", example = "1")
	private Integer gender;

	/**
	 * 中文职位
	 */
	@ApiModelProperty(value = "中文职位", example = "行政前台")
	private String position;

	/**
	 * 英文职位
	 */
	@ApiModelProperty(value = "英文职位", example = "xxxx")
	private String positionEn;

	/**
	 * 兼职标记（0 本职 / 1 兼职）
	 */
	private Integer extraJobFlag;

	/**
	 * 邮箱
	 */
	private String mail;

	/**
	 * 固定电话
	 */
	@ApiModelProperty(value = "固定电话", example = "029-11111111")
	private String homePhone;

	/**
	 * 排序值
	 */
	@ApiModelProperty(value = "排序值", example = "1")
	private Integer ord;

	/**
	 * 用户对象来源(local|""/ldap/weixin/dingding)
	 */
	private String entrySource;

	/**
	 * 用户对象来源id
	 */
	private String entryid;

	/**
	 * 用户对象来源父id
	 */
	private String entrypid;
}
