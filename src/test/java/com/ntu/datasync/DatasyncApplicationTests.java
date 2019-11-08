package com.ntu.datasync;

import com.ntu.datasync.config.MoquetteServer;
import io.moquette.broker.Server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DatasyncApplicationTests {
	@Autowired
	private MoquetteServer moquetteServer;
	@Test
	void contextLoads() throws IOException {
		moquetteServer.startServer();
	}

}
