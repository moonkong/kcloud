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

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kcloud.common.base.utils.R;
import com.kcloud.umc.model.entity.SysRole;
import com.kcloud.umc.model.entity.SysUserRole;
import com.kcloud.umc.service.SysRoleService;
import com.kcloud.umc.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lengleng
 * @date 2017/11/5
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role")
@Api(value = "role", description = "角色管理模块")
public class RoleController {
	private final SysRoleService sysRoleService;
	private final SysUserRoleService sysUserRoleService;

	/**
	 * 通过ID查询角色信息
	 *
	 * @param id ID
	 * @return 角色信息
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "通过ID查询角色信息", notes = "通过ID查询角色信息")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysRoleService.getById(id));
	}

	/**
	 * 添加角色
	 *
	 * @param sysRole 角色信息
	 * @return success、false
	 */
	@PostMapping
	@ApiOperation(value = "添加角色", notes = "添加角色")
	public R save(@Valid @RequestBody SysRole sysRole) {
		// 初始化数据权限为全部
		sysRole.setDsType(0);
		sysRole.setDsScope("");
		return new R<>(sysRoleService.save(sysRole));
	}

	/**
	 * 修改角色
	 *
	 * @param sysRole 角色信息
	 * @return success/false
	 */
	@PutMapping
	@ApiOperation(value = "修改角色", notes = "修改角色")
	public R update(@Valid @RequestBody SysRole sysRole) {
		Boolean b = sysRoleService.updateById(sysRole);
		return new R<>(b);
	}

	/**
	 * 删除角色
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除角色", notes = "删除角色")
	public R removeById(@PathVariable Integer id) {
		int count = sysUserRoleService.count(Wrappers.<SysUserRole>query().lambda().eq(SysUserRole::getRoleId, id));
		if(count > 0){
			return R.builder().data(Boolean.FALSE).msg(String.format("当前角色下存在%s个用户，请先转移用户", count)).build();
		}
		Boolean b = sysRoleService.removeById(id);
		return new R<>(b);
	}

	/**
	 * 获取角色列表
	 *
	 * @return 角色列表
	 */
	@GetMapping("/list")
	@ApiOperation(value = "获取角色列表", notes = "获取角色列表")
	public R listRoles() {
		return new R<>(sysRoleService.list(Wrappers.emptyWrapper()));
	}

	/**
	 * 分页查询角色信息
	 *
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页查询角色信息", notes = "分页查询角色信息")
	public R getRolePage(Page page) {
		return new R<>(sysRoleService.page(page, Wrappers.emptyWrapper()));
	}

}
