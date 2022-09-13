package com.example.employeeMapStruct;

import com.example.employeeMapStruct.enitity.EmployeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class EmployeeMapStructApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMapStructApplication.class, args);
	}

}
