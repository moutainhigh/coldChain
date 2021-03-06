package com.coldchain.controller;


import com.coldchain.entity.AdminLog;
import com.coldchain.service.AdminLogService;
import com.common.vo.SBApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dyr
 * @since 2019-12-09
 */
@RestController
@RequestMapping("/admin_log")
public class AdminLogController {
    @Autowired
    private AdminLogService adminLogService;

    @PostMapping
    public SBApi add(AdminLog adminLog, SBApi sbApi) {
        adminLogService.save(adminLog);
        return sbApi;
    }
}
