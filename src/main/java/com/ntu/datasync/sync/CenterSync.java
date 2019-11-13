package com.ntu.datasync.sync;

import com.ntu.datasync.config.MoquetteServer;
import com.ntu.datasync.config.SysConfig;
import com.ntu.datasync.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: baihua
 * @Date: Created in 11/11/2019 10:41 AM
 */
@Component
public class CenterSync {

    private MoquetteServer moquetteServer = null;
    @Autowired
    BookMapper bookMapper;

    public void start(MoquetteServer moquetteServer){


        SysConfig sysConfig = new SysConfig();
        sysConfig.setClintid("center");
        IMQTTClient imqttClient = new EMQTTClient(sysConfig.getClintid(),sysConfig.getClintid(),sysConfig.getPassword());

        imqttClient.connect();
        imqttClient.subscribe("/sync/test");

        System.out.println("center "+ bookMapper.findAll());


    }



}
