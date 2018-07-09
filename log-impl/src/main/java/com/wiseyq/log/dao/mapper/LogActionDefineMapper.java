package com.wiseyq.log.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wiseyq.log.model.ActionDefine;

@Mapper
public interface LogActionDefineMapper {
	int insert(ActionDefine logActionDefine);

	int update(ActionDefine logActionDefine);

	int deleteById(@Param("id") int id);

	ActionDefine findLogActionDefine(@Param("id") int id);

	List<ActionDefine> findLogActionDefineList(ActionDefine logActionDefine);
}
