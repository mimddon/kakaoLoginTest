package login.kakaologintest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HTTP 보안 설정을 구성 URL 패턴에 대한 접근 권한을 설정하고, 로그인 및 로그아웃 관련 설정을 구성
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() //public 으로 시작하는 URL 에 대한 접근을 모든 사용자에게 허용
                .antMatchers("/private/**").authenticated() //private 로 시작하는 URL 에 대한 접근은 인증된 사용자에게만 허용
                .and()
                .formLogin()
                .loginPage("/login") //로그인 페이지의 경로설정
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") //로그아웃 후 redirect 페이지 경로설정
                .and()
                .csrf().disable(); // CSRF 보안 비활성화 (개발용)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService); // JPA를 사용한 UserDetailsService를 사용
    }

}
