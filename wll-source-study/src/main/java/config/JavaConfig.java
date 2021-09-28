package config;

import domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: weiliangliang
 * @description:
 * @date: 2021/8/26 下午11:29
 */
@Configuration
@ComponentScan
public class JavaConfig {

	@Bean
	public User user(){
		return new User("001","smart哥");
	}


}
