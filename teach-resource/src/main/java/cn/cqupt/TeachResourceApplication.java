package cn.cqupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("cn.cqupt")
@MapperScan("cn.cqupt.teachresource.mapper")//将项目中对应的mapper类的路径加进来就可以了cn.cqupt.teachresource.mapper
@ImportResource("classpath:dubbo-consumer.xml")
public class TeachResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachResourceApplication.class, args);
	}

}
