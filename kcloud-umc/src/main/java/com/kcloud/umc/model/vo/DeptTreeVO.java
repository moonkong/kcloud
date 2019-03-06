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

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date
 * 部门树
 */
@Data
public class DeptTreeVO{

	/**
	 * 部门中文名
	 */
	private String name;

	/**
	 * 部门英文名
	 */
	private String nameEn;

	/**
	 * 部门排序值
	 */
	private Integer sort;

	protected int id;
	protected int parentId;

	protected List<DeptTreeVO> children = new ArrayList<DeptTreeVO>();
}
