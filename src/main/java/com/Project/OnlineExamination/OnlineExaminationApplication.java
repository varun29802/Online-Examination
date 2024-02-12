package com.Project.OnlineExamination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
public class OnlineExaminationApplication 
{
	public static void main(String[] args)
	{
		SpringApplication.run(OnlineExaminationApplication.class, args);
	}

}