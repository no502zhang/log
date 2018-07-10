package com.wiseyq.log.controller;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.service.ActionLogService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log/actionLogs")
public class ActionLogController {
    @Autowired
    private ActionLogService actionLogService;

    @PostMapping("/add")
    public ResponseEntity<ActionLog> add(@RequestBody ActionLog actionLog) {
        if (StringUtils.isBlank(actionLog.getParkId())) {
            // TODO
            actionLog.setParkId("");
        }
        actionLogService.insert(actionLog);
        return ResponseEntity.ok().body(actionLog);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount(@RequestParam("parkId") String parkId,
            @RequestParam("actionCode") String actionCode, @RequestParam("sourceId") String sourceId) {
        return ResponseEntity.ok().body(0);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActionLog> getAction(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/list/")
    public ResponseEntity<PageInfo<ActionLog>> listAction(ActionLog actionLog, Integer pageNum, Integer pageSize) {
        return ResponseEntity.ok().body(null);
    }
}
