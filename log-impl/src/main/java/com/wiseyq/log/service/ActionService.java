package com.wiseyq.log.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.LogActionDefine;

public interface ActionService {
	void insert(LogActionDefine logActionDefine);

	void update(LogActionDefine logActionDefine);

	void deleteById(@Param("id") int id);

	LogActionDefine findLogActionDefine(@Param("id") int id);

	PageInfo<LogActionDefine> findLogActionDefinePage(LogActionDefine logActionDefine, Integer pageNum,
			Integer pageSize);
}
