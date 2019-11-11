package com.ntu.datasync;

import com.ntu.datasync.config.MoquetteServer;
import com.ntu.datasync.sync.CenterSync;
import com.ntu.datasync.sync.NodeSync;
import io.moquette.broker.Server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DatasyncApplicationTests {
	@Autowired
	private MoquetteServer moquetteServer;
	@Autowired
	private CenterSync centerSync;
	@Autowired
	private NodeSync nodeSync;
	@Test
	void contextLoads() throws IOException, InterruptedException {
		centerSync.start(moquetteServer);
		nodeSync.start(moquetteServer);

		Thread.sleep(60000);
		moquetteServer.stop();
	}

}
