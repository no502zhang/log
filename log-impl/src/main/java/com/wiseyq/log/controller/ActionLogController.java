package com.wiseyq.log.controller;

import com.github.pagehelper.PageInfo;
import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.model.ActionRecord;
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
    public ResponseEntity<Long> getCount(@RequestParam(value = "parkId", required = false) String parkId,
                                         @RequestParam("actionCode") String actionCode,
                                         @RequestParam(value = "sourceId", required = false) String sourceId) {
        if (StringUtils.isBlank(parkId)) {
            // TODO
        }
        ActionLog logActionLog = new ActionLog();
        logActionLog.setParkId(parkId);
        logActionLog.setActionCode(actionCode);
        logActionLog.setSourceId(sourceId);
        long count = actionLogService.count(logActionLog);
        return ResponseEntity.ok().body(count);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActionRecord> getAction(@PathVariable("id") long id) {
        ActionRecord record = actionLogService.findLogActionRecordById(id);
        if (record != null) {
            return ResponseEntity.ok().body(record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list/")
    public ResponseEntity<PageInfo<ActionRecord>> listAction(ActionLog actionLog, Integer pageNum, Integer pageSize) {
        PageInfo<ActionRecord> page = actionLogService.findLogActionRecordPage(actionLog, pageNum, pageSize);
        return ResponseEntity.ok().body(page);
    }
}
