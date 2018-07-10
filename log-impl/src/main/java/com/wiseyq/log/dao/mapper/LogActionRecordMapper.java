package com.wiseyq.log.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wiseyq.log.model.ActionRecord;

@Mapper
public interface LogActionRecordMapper {
    int insert(ActionRecord logActionRecord);

    int update(ActionRecord logActionRecord);

    ActionRecord findLogActionRecord(@Param("id") long id);

    List<ActionRecord> findLogActionRecordList(ActionRecord logActionRecord);

    long count(ActionRecord logActionRecord);
}
