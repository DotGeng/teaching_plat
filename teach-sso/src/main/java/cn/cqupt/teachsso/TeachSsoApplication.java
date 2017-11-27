package cn.cqupt.teachsso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan("cn.cqupt.teachsso")
@MapperScan("cn.cqupt.teachsso.mapper")//将项目中对应的mapper类的路径加进来就可以了
@ImportResource("classpath:dubbo-provider.xml")// 这里需要一个xsd文件
public class TeachSsoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeachSsoApplication.class, args);
	}
}
