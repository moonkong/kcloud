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
import com.kcloud.common.base.utils.R;
import com.kcloud.umc.model.entity.SysDept;
import com.kcloud.umc.model.entity.SysUser;
import com.kcloud.umc.service.SysDeptService;
import com.kcloud.umc.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author
 * @since
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dept")
@Api(value = "dept", description = "部门管理模块")
public class DeptController {
	private final SysDeptService sysDeptService;
	private final SysUserService sysUserService;

	/**
	 * 添加
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@PostMapping
	@ApiOperation(value = "添加部门", notes = "添加部门")
	public R save(@Valid @RequestBody SysDept sysDept) {
		return new R<>(sysDeptService.saveDept(sysDept));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除部门", notes = "删除部门")
	public R removeById(@PathVariable Integer id) {
		int count = sysUserService.count(Wrappers.<SysUser>query().lambda().eq(SysUser::getDeptId, id));
		if(count > 0){
			return R.builder().data(Boolean.FALSE).msg(String.format("当前部门下存在%s个用户，请先转移用户", count)).build();
		}
		Boolean b = sysDeptService.removeDeptById(id);
		return new R<>(b);
	}

	/**
	 * 编辑
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@PutMapping
	@ApiOperation(value = "编辑部门", notes = "编辑部门")
	public R update(@Valid @RequestBody SysDept sysDept) {
		sysDept.setUpdateTime(LocalDateTime.now());
		Boolean b = sysDeptService.updateDeptById(sysDept);
		return new R<>(b);
	}

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "通过ID查询部门", notes = "通过ID查询部门")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysDeptService.getById(id));
	}

	/**
	 * 通过ID查询部门树，包含子部门
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/getByIdForDeptTree/{id}")
	@ApiOperation(value = "通过ID查询部门", notes = "通过ID查询部门")
	public R getByIdForDeptTree(@PathVariable Integer id) {
		return new R<>(sysDeptService.getDeptTreeById(id));
	}


}
