package com.wiseyq.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseyq.log.dao.mapper.LogActionRecordMapper;
import com.wiseyq.log.model.ActionDefine;
import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.model.ActionRecord;
import com.wiseyq.log.service.ActionLogService;
import com.wiseyq.log.service.ActionService;

import java.util.List;

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

    @Override
    public long count(ActionLog logActionLog) {
        ActionDefine action = actionService.findLogActionDefineByCode(logActionLog.getParkId(),
                logActionLog.getActionCode());
        if (action == null) {
            throw new IllegalArgumentException("actionCode不存在");
        }
        ActionRecord record = new ActionRecord();
        record.setParkId(action.getParkId());
        record.setActionId(action.getId());
        record.setSourceId(logActionLog.getSourceId());
        return actionRecordMapper.count(record);
    }

    @Override
    public ActionRecord findLogActionRecordById(long id) {
        return actionRecordMapper.findLogActionRecord(id);
    }

    @Override
    public PageInfo<ActionRecord> findLogActionRecordPage(ActionLog logActionLog, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        ActionRecord record = new ActionRecord();
        record.setParkId(logActionLog.getParkId());
        record.setSourceId(logActionLog.getSourceId());
        if (StringUtils.isNotBlank(logActionLog.getActionCode())) {
            ActionDefine action = actionService.findLogActionDefineByCode(logActionLog.getParkId(),
                    logActionLog.getActionCode());
            if (action == null) {
                throw new IllegalArgumentException("actionCode不存在");
            }
            record.setActionId(action.getId());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<ActionRecord> list = actionRecordMapper.findLogActionRecordList(record);
        return new PageInfo<ActionRecord>(list);
    }
}
