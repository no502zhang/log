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
	public ActionDefine findLogActionDefine(int id) {
		return actionDefineMapper.findLogActionDefine(id);
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
