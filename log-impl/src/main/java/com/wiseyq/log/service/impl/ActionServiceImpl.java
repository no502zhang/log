package com.wiseyq.log.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wiseyq.log.dao.mapper.LogActionDefineMapper;
import com.wiseyq.log.model.ActionDefine;
import com.wiseyq.log.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    private LogActionDefineMapper actionDefineMapper;

    @Override
    public void insert(ActionDefine logActionDefine) {
        actionDefineMapper.insert(logActionDefine);
    }

    @Override
    public void update(ActionDefine logActionDefine) {
        actionDefineMapper.update(logActionDefine);
    }

    @Override
    public void deleteById(int id) {
        actionDefineMapper.deleteById(id);
    }

    @Override
    public ActionDefine findLogActionDefineById(int id) {
        ActionDefine logActionDefine = new ActionDefine();
        logActionDefine.setId(id);
        return actionDefineMapper.findLogActionDefine(logActionDefine);
    }

    @Override
    public ActionDefine findLogActionDefineByCode(String parkId, String actionCode) {
        ActionDefine action = null;
        ActionDefine logActionDefine = new ActionDefine();
        logActionDefine.setParkId(parkId);
        logActionDefine.setCode(actionCode);
        action = actionDefineMapper.findLogActionDefine(logActionDefine);
        if (action == null) {
            // 约定先于配置
            // 当前园区没有配置时, 取默认配置
            ActionDefine defaultActionQuery = new ActionDefine();
            defaultActionQuery.setCode(actionCode);
            action = actionDefineMapper.findLogActionDefine(defaultActionQuery);
        }
        return actionDefineMapper.findLogActionDefine(logActionDefine);
    }

    @Override
    public PageInfo<ActionDefine> findLogActionDefinePage(ActionDefine logActionDefine, Integer pageNum,
            Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ActionDefine> list = actionDefineMapper.findLogActionDefineList(logActionDefine);
        return new PageInfo<ActionDefine>(list);
    }

}
