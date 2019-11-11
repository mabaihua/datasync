package com.ntu.datasync;

import com.ntu.datasync.sync.CenterSync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatasyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasyncApplication.class, args);
	}

}
