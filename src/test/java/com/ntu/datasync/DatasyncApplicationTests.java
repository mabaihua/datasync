package com.ntu.datasync;

import io.moquette.broker.Server;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DatasyncApplicationTests {

	@Test
	void contextLoads() throws IOException {
		Server.main(null);
	}

}
