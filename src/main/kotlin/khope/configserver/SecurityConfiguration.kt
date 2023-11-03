package khope.configserver

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    protected fun configure(http: HttpSecurity) {
        http
            .formLogin()
            .and()

            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()

            .cors().disable()
            .csrf().disable()
    }
}