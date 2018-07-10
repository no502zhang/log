package com.wiseyq.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseyq.log.dao.mapper.LogActionRecordMapper;
import com.wiseyq.log.model.ActionDefine;
import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.model.ActionRecord;
import com.wiseyq.log.service.ActionLogService;
import com.wiseyq.log.service.ActionService;

@Service
public class ActionLogServiceImpl implements ActionLogService {
    @Autowired
    private LogActionRecordMapper actionRecordMapper;

    @Autowired
    private ActionService actionService;

    @Override
    public void insert(ActionLog logActionLog) {
        ActionDefine action = actionService.findLogActionDefineByCode(logActionLog.getParkId(),
                logActionLog.getActionCode());
        if (action == null) {
            throw new IllegalArgumentException("actionCode不存在");
        }
        ActionRecord record = new ActionRecord();
        record.setParkId(action.getParkId());
        record.setActionId(action.getId());
        actionRecordMapper.insert(record);
    }
}
