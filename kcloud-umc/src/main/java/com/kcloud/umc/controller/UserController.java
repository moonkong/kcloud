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

package com.kcloud.umc.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kcloud.common.base.utils.R;
import com.kcloud.umc.model.dto.UserDTO;
import com.kcloud.umc.model.entity.SysUser;
import com.kcloud.umc.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户接口
 *
 * @author
 * @date 2019/1/10
 */

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	private final SysUserService userService;

	/**
	 * 添加用户
	 *
	 * @param userDto 用户信息
	 * @return success/false
	 */
	@PostMapping
	@ApiOperation(value = "添加用户", notes = "添加用户")
	public R user(@Valid @RequestBody UserDTO userDto) {
		Boolean b = userService.saveUser(userDto);
		return new R<>(b);
	}

	/**
	 * 更新用户信息
	 *
	 * @param userDto 用户信息
	 * @return R
	 */
	@PutMapping
	public R updateUser(@Valid @RequestBody UserDTO userDto) {
		Boolean b = userService.updateById(userDto);
		return new R<>(b);
	}

	/**
	 * 删除用户信息
	 *
	 * @param id ID
	 * @return R
	 */
	@DeleteMapping("/{id}")
	public R userDel(@PathVariable Integer id) {
		return new R<>(userService.removeById(id));
	}

	/**
	 * 通过ID查询用户信息（包含用户信息、角色）
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public R user(@PathVariable Integer id) {
		return new R<>(userService.getById(id));
	}


	/**
	 * 分页查询用户
	 *
	 * @param page    参数集
	 * @param userDTO 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/page")
	public R getUserPage(Page page, UserDTO userDTO) {
		return new R<>(userService.getUsersWithRolePage(page, userDTO));
	}

}
