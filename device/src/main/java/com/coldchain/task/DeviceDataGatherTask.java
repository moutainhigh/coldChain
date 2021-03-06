package com.coldchain.task;

import com.coldchain.service.CpDeviceService;
import com.coldchain.service.CpSensorDataService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 设备传感器数据采集
 * @author chenqingshan
 * @since 2020-10-19 19:50:30
 */
@Log
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DeviceDataGatherTask {

    @Autowired
    private CpDeviceService cpDeviceService;

    @Autowired
    private CpSensorDataService cpSensorDataService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void getDeviceData() {

        cpSensorDataService.getDeviceData();
    }


}
