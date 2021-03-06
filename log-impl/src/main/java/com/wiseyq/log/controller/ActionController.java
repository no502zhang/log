package com.wiseyq.log.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.wiseyq.core.security.SessionUtil;
import com.wiseyq.log.model.ActionDefine;
import com.wiseyq.log.service.ActionService;

@RestController
@RequestMapping("/log/actions")
public class ActionController {
    @Autowired
    private ActionService actionService;

    @PostMapping({ "/add", "/add/" })
    public ResponseEntity<ActionDefine> add(@RequestBody ActionDefine action) {
        actionService.insert(action);
        return ResponseEntity.ok().body(action);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        actionService.deleteById(id);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ActionDefine> update(@PathVariable("id") int id, @RequestBody ActionDefine action) {
        action.setId(id);
        actionService.update(action);
        return ResponseEntity.ok().body(action);
    }

    @GetMapping({ "/get/{id}", "/get", "/get/" })
    public ResponseEntity<ActionDefine> getAction(@PathVariable(value = "id", required = false) Integer id,
            String parkId, String code) {
        ActionDefine action = null;
        if (id != null) {
            action = actionService.findLogActionDefineById(id);
        } else if (StringUtils.isNotBlank(code)) {
            if (StringUtils.isBlank(parkId)) {
                parkId = SessionUtil.getParkId();
            }
            action = actionService.findLogActionDefineByCode(parkId, code);
        }
        if (action != null) {
            return ResponseEntity.ok().body(action);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping({ "/list", "/list/" })
    public ResponseEntity<PageInfo<ActionDefine>> listAction(ActionDefine action, Integer pageNum, Integer pageSize) {
        PageInfo<ActionDefine> page = actionService.findLogActionDefinePage(action, pageNum, pageSize);
        return ResponseEntity.ok().body(page);
    }
}
