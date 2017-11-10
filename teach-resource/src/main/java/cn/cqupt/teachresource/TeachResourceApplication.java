package cn.cqupt.teachresource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("cn.cqupt.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class TeachResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachResourceApplication.class, args);
	}

}
