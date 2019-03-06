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

package com.kcloud.umc.model.vo;

import com.kcloud.umc.model.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author
 * @date
 */
@Data
public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 随机盐
	 */
	private String salt;

	/**
	 * 微信openid
	 */
	private String wxOpenid;

	/**
	 * 钉钉 openid
	 */
	private String ddOpenid;

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
	private String delFlag;

	/**
	 * 锁定标记
	 */
	private String lockFlag;
	/**
	 * 简介
	 */
	private String phone;
	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 部门ID
	 */
	private Integer deptId;

	/**
	 * 租户ID
	 */
	private Integer tenantId;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 角色列表
	 */
	private List<SysRole> roleList;

	/**
	 * 中文名
	 */
	private String realName;

	/**
	 * 英文名
	 */
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
	private Integer gender;

	/**
	 * 中文职位
	 */
	private String position;

	/**
	 * 英文职位
	 */
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
	private String homePhone;

	/**
	 * 排序值
	 */
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
