package com.ntu.datasync.sync;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MsgSerializer {
	
	public byte[] encode(SyncMessage obj) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.close();
			byte[] buff = bos.toByteArray();
			return buff;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SyncMessage decode(byte[] data) {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		try {
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (SyncMessage)ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
