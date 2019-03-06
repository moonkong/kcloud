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

package com.kcloud.umc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.kcloud.umc.mapper.SysDeptMapper;
import com.kcloud.umc.model.entity.SysDept;
import com.kcloud.umc.model.vo.DeptTreeVO;
import com.kcloud.umc.service.SysDeptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门类
 * </p>
 *
 * @author
 * @since
 */
@Service
@AllArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {


	/**
	 * 添加信息部门
	 *
	 * @param dept 部门
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean saveDept(SysDept dept) {
		SysDept sysDept = new SysDept();
		BeanUtils.copyProperties(dept, sysDept);
		this.save(sysDept);
		return Boolean.TRUE;
	}


	/**
	 * 删除部门
	 *
	 * @param id 部门 ID
	 * @return 成功、失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean removeDeptById(Integer id) {
		this.removeById(id);
		return Boolean.TRUE;
	}

	/**
	 * 更新部门
	 *
	 * @param sysDept 部门信息
	 * @return 成功、失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateDeptById(SysDept sysDept) {
		//更新部门状态
		this.updateById(sysDept);
		return Boolean.TRUE;
	}

	@Override
	public List<DeptTreeVO> getDeptTreeById(Integer pid) {
		// 查出所有部门
		List<SysDept> depts = this.list();

		List<DeptTreeVO> trees = Lists.newArrayList();
		setChild(depts,trees,pid);
		return trees;
	}

	/**
	 * 根据ID递归查询部门下的子部门
	 * @param depts
	 * @param id
	 */
	private void setChild(List<SysDept> depts,List<DeptTreeVO> trees ,Integer id){
		List<SysDept> treest =depts.stream().filter(o->o.getParentId()==id).collect(Collectors.toList());

		for (SysDept sysDept : treest) {
			DeptTreeVO dept = new DeptTreeVO();
			dept.setId(sysDept.getDeptId());
			dept.setName(sysDept.getName());
			dept.setParentId(sysDept.getParentId());
			List<DeptTreeVO> cdepts= Lists.newArrayList();
			setChild(depts,cdepts,sysDept.getDeptId());
			dept.setChildren(cdepts);
			trees.add(dept);
		}

	}


}
