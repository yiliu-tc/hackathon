package ca.gc.tc.hackathon.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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
        auth.inMemoryAuthentication()
                .withUser("test").password(passwordEncoder.encode("123")).roles("USER").and()
                .withUser("user").password(passwordEncoder.encode("pass1234")).roles("ADMIN");
    }
}
