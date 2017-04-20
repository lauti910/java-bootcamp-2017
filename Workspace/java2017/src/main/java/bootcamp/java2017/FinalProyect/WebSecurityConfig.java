package bootcamp.java2017.FinalProyect;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/users*").permitAll();
		http.authorizeRequests().antMatchers("/items*").permitAll();
		http.authorizeRequests().and().formLogin().loginPage("/users").usernameParameter("username").passwordParameter("password");
		http.authorizeRequests().antMatchers("/cart/**").fullyAuthenticated().and().
		httpBasic().and().
		csrf().disable();
	}
  
}