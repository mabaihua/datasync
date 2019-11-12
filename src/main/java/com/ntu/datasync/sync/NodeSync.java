package com.ntu.datasync.sync;

import com.ntu.datasync.config.MoquetteServer;
import com.ntu.datasync.config.SysConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: baihua
 * @Date: Created in 11/11/2019 11:41 AM
 */
@Component
public class NodeSync {
    private MoquetteServer moquetteServer = null;


    public void start(MoquetteServer moquetteServer){


        SysConfig sysConfig = new SysConfig();
        IMQTTClient imqttClient = new EMQTTClient(sysConfig.getClintid(),sysConfig.getClintid(),sysConfig.getPassword());
        imqttClient.connect();
        imqttClient.publish("/sync/test","message sender".getBytes(),false);
    }
}
