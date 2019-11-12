package com.ntu.datasync.sync;

import com.ntu.datasync.entity.DataSynchro;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Author: baihua
 * @Date: Created in 11/12/2019 11:06 AM
 */
@Data
@Getter
@Setter
public class SyncMessage implements Serializable {

    private static final long serialVersionUID = -6468546683623763722L;
    private String id = "";
    private int msqtype = 0;
    private String clientid = "";
    private DataSynchro dataSynchro;
    private Object data;

    public SyncMessage(){
        id = UUID.randomUUID().toString();
    }

    public SyncMessage(int msqtype, String clientid, DataSynchro dataSynchro, Object data){
        this.clientid = clientid;
        this.msqtype = msqtype;
        this.dataSynchro = dataSynchro;
        this.data = data;
    }
}
