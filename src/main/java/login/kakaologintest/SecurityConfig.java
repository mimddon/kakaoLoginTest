package login.kakaologintest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll() // 특정 URL 패턴에 대해 로그인 없이 액세스 허용
                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                .and()
                .formLogin()
                .loginPage("/login") // 로그인 페이지 설정
                .permitAll(); // 로그인 페이지는 누구나 액세스 가능
    }
}
