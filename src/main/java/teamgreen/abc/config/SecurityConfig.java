
package teamgreen.abc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**", "/images/**", "/error/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/loginForm/**", "/signUp/**").permitAll()
                    .anyRequest().authenticated()
                .and() // 여기서 끝
                .formLogin() // x-www-form-urlencoded , json으로 던지면 안된다. 결국 폼태그를 만들어야한다.
                    .loginPage("/loginForm?cd=needLogin")//로그인 페이지로 리다이렉션됨
                    .loginProcessingUrl("/Login.do")
                    .failureUrl("/loginForm?cd=failed")
                    .defaultSuccessUrl("/")
                    .and()
                .logout()
                    .logoutUrl("/Logout.do")
                    .logoutSuccessUrl("/loginForm");

    }

}
