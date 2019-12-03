package com.dm.linfen.config;

import com.dm.linfen.dto.MonitorManagerDto;
import com.dm.linfen.service.MonitorManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class SwitchConfig {

    @Autowired
    private MonitorManagerService monitorManagerService;


    @PostConstruct
    public  void  initSwitch() {
        autoTurnOn();
    }

    //  在启动的时候自动启动
    private void  autoTurnOn() {
        List<MonitorManagerDto> list =monitorManagerService.findByRun(true);
        list.forEach(ele -> {
            if (ele.getCameraUrl().contains("admin:dhs123456@htdhs.gnway.cc:30001")){
                monitorManagerService.transferStreamToLocal(ele.getId());
            }
        });
    }
}
