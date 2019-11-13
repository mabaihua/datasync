package com.ntu.datasync.sync;

import com.ntu.datasync.config.MoquetteServer;
import com.ntu.datasync.config.SysConfig;
import com.ntu.datasync.dao.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: baihua
 * @Date: Created in 11/11/2019 11:41 AM
 */
@Component
public class NodeSync {

    private static final Logger logger = LoggerFactory.getLogger(NodeSync.class);
    @Autowired
    BookMapper bookMapper;

    public void start(MoquetteServer moquetteServer){


        SysConfig sysConfig = new SysConfig();
        IMQTTClient imqttClient = new EMQTTClient(sysConfig.getClintid(),sysConfig.getClintid(),sysConfig.getPassword());
        imqttClient.connect();
        imqttClient.publish("/sync/test","message sender".getBytes(),false);
        logger.info("node: "+bookMapper.findAll());
    }
}
