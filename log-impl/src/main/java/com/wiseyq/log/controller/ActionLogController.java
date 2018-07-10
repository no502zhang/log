package com.wiseyq.log.controller;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionLog;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wiseyq.log.model.ActionDefine;

@RestController
@RequestMapping("/log/actionLogs")
public class ActionLogController {
    @PostMapping("/add")
    public ResponseEntity<ActionLog> add(@RequestBody ActionLog actionLog) {
        return ResponseEntity.ok().body(actionLog);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount(@RequestParam("parkId") String parkId, @RequestParam("actionCode") String actionCode) {
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
