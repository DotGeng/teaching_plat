package cn.cqupt.teachsso;

import cn.cqupt.teachfaced.service.StudentLoadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachSsoApplicationTests {

	@Autowired
	private StudentLoadService studentLoadService;
	@Test
	public void contextLoads() {
		boolean bool = studentLoadService.studentIsLoaded("12121");
		System.out.println(bool);
	}

}
