package com.ntu.datasync.sync;

import com.ntu.datasync.common.ApplicationContextProvider;
import com.ntu.datasync.config.DataSourceType;
import com.ntu.datasync.dao.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: baihua
 * @Date: 2019/11/25 11:48
 */
public class SendThread implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SendThread.class);

    private ApplicationContextProvider applicationContextProvider;

    @Autowired
    String role;

    public SendThread(String role, ApplicationContextProvider context){
        applicationContextProvider = context;
        this.role = role;

    }
    @Override
    public void run() {
        if(role.equals("center")){
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);
        }else {
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Secondary);
        }
        BookMapper bookMapper = (BookMapper) applicationContextProvider.getBean("bookMapper");

        while(true){
            logger.info(role+bookMapper.findAll());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
