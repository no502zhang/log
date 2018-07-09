package com.wiseyq.log.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiseyq.log.model.ActionDefine;

@RestController
@RequestMapping("/log/actionLogs")
public class ActionLogController {
    @PostMapping("/")
    public ResponseEntity<ActionDefine> add(ActionDefine action) {
        return ResponseEntity.ok().body(action);
    }

    @GetMapping("/log/actionLogs/count")
    public ResponseEntity<Integer> getCount(ActionDefine action) {
        return ResponseEntity.ok().body(0);
    }
}
