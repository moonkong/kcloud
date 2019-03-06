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

package com.kcloud.common.base.constant;

/**
 * @author
 * @date
 */
public interface CommonConstants {

	/**
	 * 服务监控请求前缀
	 */
	String ACTUATOR_PREFIX_URL = "/actuator";

	/**
	 * 认证服务请求前缀
	 */
	String OAUTH_PREFIX_URL = "/oauth";

	/**
	 * header 中租户ID标识
	 */
	String TENANT_ID = "TENANT_ID";

	/**
	 * header 中feign标识
	 */
	String FEIGN = "FEIGN";

	/**
	 * 域名
	 */
	String DOMAIN = "domain";

	/**
	 * 用户名
	 */
	String USERNAME = "username";

	/**
	 * 客户端租户id
	 */
	Integer CLIENT_TENANT_ID = -1;

	/**
	 * 平台管理员租户id
	 */
	Integer PLATFORM_ADMIN_TENANT_ID = 0;

	/**
	 * 平台管理员域
	 */
	String PLATFORM_ADMIN_DOMAIN = "virsical.com";

	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 菜单
	 */
	String MENU = "0";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "pigx-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "pigx";

	/**
	 * 路由存放
	 */
	String ROUTE_KEY = "gateway_route_key";

	/**
	 * spring boot admin 事件key
	 */
	String EVENT_KEY = "event_key";

	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * Email正则表达式
	 */
	String EMAIL_REGEX = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

	/**
	 * 字符@
	 */
	String ALT = "@";
}
