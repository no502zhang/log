package com.wiseyq.log.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionDefine;

public interface ActionService {
	void insert(ActionDefine logActionDefine);

	void update(ActionDefine logActionDefine);

	void deleteById(@Param("id") int id);

	ActionDefine findLogActionDefine(@Param("id") int id);

	PageInfo<ActionDefine> findLogActionDefinePage(ActionDefine logActionDefine, Integer pageNum,
			Integer pageSize);
}
