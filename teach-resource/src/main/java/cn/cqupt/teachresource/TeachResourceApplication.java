package cn.cqupt.teachresource;

import cn.cqupt.teachfaced.service.StudentLoadService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@SpringBootApplication
@ComponentScan("cn.cqupt")
@MapperScan("cn.cqupt.teachresource.mapper")//将项目中对应的mapper类的路径加进来就可以了cn.cqupt.teachresource.mapper
@ImportResource("classpath:dubbo-consumer.xml")
public class TeachResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachResourceApplication.class, args);
		/*ConfigurableApplicationContext run = SpringApplication.run(TeachResourceApplication.class, args);
		StudentLoadService studentLoadService = run.getBean(StudentLoadService.class);
		Method[] methods = studentLoadService.getClass().getDeclaredMethods();

		//Loop through the methods and print out their names
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println(studentLoadService.getClass().getDeclaredMethods());*/
	}

}
