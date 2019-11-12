package com.ntu.datasync.sync;

import com.ntu.datasync.DatasyncApplication;
import com.ntu.datasync.config.MoquetteServer;
import com.ntu.datasync.config.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.io.IOException;

/**
 * @Author: baihua
 * @Date: Created in 11/11/2019 10:41 AM
 */
@Component
public class CenterSync {

    private MoquetteServer moquetteServer = null;


    public void start(MoquetteServer moquetteServer){


        SysConfig sysConfig = new SysConfig();
        sysConfig.setClintid("center");
        IMQTTClient imqttClient = new EMQTTClient(sysConfig.getClintid(),sysConfig.getClintid(),sysConfig.getPassword());

        imqttClient.connect();
        imqttClient.subscribe("/sync/test");


    }



}
