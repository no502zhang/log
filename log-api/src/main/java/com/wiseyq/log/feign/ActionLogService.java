package com.wiseyq.log.feign;

import com.wiseyq.log.model.ActionLog;
import com.wiseyq.log.model.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("LOG-SERVICE")
public interface ActionLogService {

    @PostMapping("/log/actionLogs/add")
    ActionLog add(@RequestBody ActionLog action);

    @GetMapping("/log/actionLogs/count")
    int getCount(@RequestParam("parkId") String parkId, @RequestParam("actionCode") String actionCode);

    @GetMapping("/log/actionLogs/get/{id}")
    ActionLog getAction(@PathVariable("id") int id);

    @GetMapping("/log/actionLogs/list/")
    PageInfo<ActionLog> listAction(ActionLog actionLog,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize);
}
