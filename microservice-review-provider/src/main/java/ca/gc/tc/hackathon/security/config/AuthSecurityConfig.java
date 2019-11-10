package ca.gc.tc.hackathon.security.config;

import ca.gc.tc.hackathon.entity.LoginUser;
import ca.gc.tc.hackathon.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@Configuration
@EnableWebSecurity
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private LoginUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.csrf().disable().sessionManagement()
                .and().authorizeRequests().antMatchers("/", "/index.html","/api/v1/login").permitAll()
                .antMatchers("/api/v1/reviews", "/api/v1/review", "api/v1/rating-types").hasRole("USER")
                .antMatchers("/swagger-ui.html","/swagger-resources/*", "*.html", "/api/v2/swagger.json").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
//        List<LoginUser> userList = userService.list();
//        for (LoginUser user : userList) {
//            auth.inMemoryAuthentication()
//                    .withUser(user.getUser_name()).password(passwordEncoder.encode(user.getClient_secret())).roles(user.getAuthorized_grant_type());
//        }


        auth.inMemoryAuthentication()
                .withUser("test").password(passwordEncoder.encode("123")).roles("USER").and()
                .withUser("user").password(passwordEncoder.encode("pass1234")).roles("USER");
    }
}
