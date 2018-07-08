package com.wiseyq.log.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wiseyq.log.model.LogActionDefine;

@Mapper
public interface LogActionDefineMapper {
	int insert(LogActionDefine logActionDefine);

	int update(LogActionDefine logActionDefine);

	int deleteById(@Param("id") int id);

	LogActionDefine findLogActionDefine(@Param("id") int id);

	List<LogActionDefine> findLogActionDefineList(LogActionDefine logActionDefine);
}
