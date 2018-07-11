package com.wiseyq.log.service;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.model.ActionRecord;

public interface ActionLogService {
    void insert(ActionLog logActionLog);

    long count(ActionLog logActionLog);

    ActionRecord findLogActionRecordById(long id);

    PageInfo<ActionRecord> findLogActionRecordPage(ActionLog logActionLog, Integer pageNum, Integer pageSize);
}
