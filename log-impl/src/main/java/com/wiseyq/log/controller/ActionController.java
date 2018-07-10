package com.wiseyq.log.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionDefine;
import com.wiseyq.log.service.ActionService;

@RestController
@RequestMapping("/log/actions")
public class ActionController {
    @Autowired
    private ActionService actionService;

    @PostMapping("/add/")
    public ResponseEntity<ActionDefine> add(ActionDefine action) {
        actionService.insert(action);
        return ResponseEntity.ok().body(action);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        actionService.deleteById(id);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ActionDefine> update(@PathVariable("id") int id, ActionDefine action) {
        action.setId(id);
        actionService.update(action);
        return ResponseEntity.ok().body(action);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActionDefine> getAction(@PathVariable("id") int id) {
        ActionDefine action = actionService.findLogActionDefineById(id);
        if (action != null) {
            return ResponseEntity.ok().body(action);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list/")
    public ResponseEntity<PageInfo<ActionDefine>> listAction(ActionDefine action, Integer pageNum,
                                                             Integer pageSize) {
        PageInfo<ActionDefine> page = actionService.findLogActionDefinePage(action, pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(page.getList())) {
            return ResponseEntity.ok().body(page);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
