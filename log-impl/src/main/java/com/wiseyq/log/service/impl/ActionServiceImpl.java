package com.wiseyq.log.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wiseyq.log.dao.mapper.LogActionDefineMapper;
import com.wiseyq.log.model.LogActionDefine;
import com.wiseyq.log.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {
	@Autowired
	private LogActionDefineMapper actionDefineMapper;

	@Override
	public void insert(LogActionDefine logActionDefine) {
		actionDefineMapper.insert(logActionDefine);
	}

	@Override
	public void update(LogActionDefine logActionDefine) {
		actionDefineMapper.update(logActionDefine);
	}

	@Override
	public void deleteById(int id) {
		actionDefineMapper.deleteById(id);
	}

	@Override
	public LogActionDefine findLogActionDefine(int id) {
		return actionDefineMapper.findLogActionDefine(id);
	}

	@Override
	public PageInfo<LogActionDefine> findLogActionDefinePage(LogActionDefine logActionDefine, Integer pageNum,
			Integer pageSize) {
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<LogActionDefine> list = actionDefineMapper.findLogActionDefineList(logActionDefine);
		return new PageInfo<LogActionDefine>(list);
	}

}
