package com.wiseyq.log.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.LogActionDefine;
import com.wiseyq.log.service.ActionService;

@RestController
@RequestMapping("/actions")
public class ActionController {
	@Autowired
	private ActionService actionService;

	@PostMapping("/")
	public ResponseEntity<LogActionDefine> add(LogActionDefine action) {
		actionService.insert(action);
		return ResponseEntity.ok().body(action);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		actionService.deleteById(id);
		return ResponseEntity.ok().body(true);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LogActionDefine> update(@PathVariable("id") int id, LogActionDefine action) {
		action.setId(id);
		actionService.update(action);
		return ResponseEntity.ok().body(action);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LogActionDefine> getAction(@PathVariable("id") int id) {
		LogActionDefine action = actionService.findLogActionDefine(id);
		if (action != null) {
			return ResponseEntity.ok().body(action);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<PageInfo<LogActionDefine>> listAction(LogActionDefine action, Integer pageNum,
			Integer pageSize) {
		PageInfo<LogActionDefine> page = actionService.findLogActionDefinePage(action, pageNum, pageSize);
		if (CollectionUtils.isNotEmpty(page.getList())) {
			return ResponseEntity.ok().body(page);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
