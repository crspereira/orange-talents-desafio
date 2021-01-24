package zup.orangetalents.loterrychallenge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1000) 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/actuator/**");
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", 
				                   "/configuration/**", "/swagger-ui.html", "/webjars/**");
	}
}