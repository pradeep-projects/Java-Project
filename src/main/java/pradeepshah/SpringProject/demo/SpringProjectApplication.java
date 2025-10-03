package pradeepshah.SpringProject.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import pradeepshah.SpringProject.demo.LRU.LruCache;
import pradeepshah.SpringProject.demo.hashMap.seperateChaining.HashMapImp;

@SpringBootApplication
public class SpringProjectApplication {



	public static void main(String[] args)  {
		SpringApplication.run(SpringProjectApplication.class, args);
		 LoggerConfig logger  = LoggerConfig.getLoggerInstance();

	}


}

