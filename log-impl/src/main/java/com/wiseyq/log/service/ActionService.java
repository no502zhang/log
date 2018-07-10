package com.wiseyq.log.service;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionDefine;

public interface ActionService {
    void insert(ActionDefine logActionDefine);

    void update(ActionDefine logActionDefine);

    void deleteById(int id);

    ActionDefine findLogActionDefineById(int id);

    ActionDefine findLogActionDefineByCode(String parkId, String actionCode);

    PageInfo<ActionDefine> findLogActionDefinePage(ActionDefine logActionDefine, Integer pageNum, Integer pageSize);
}
