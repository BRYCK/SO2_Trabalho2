package SO2.SO2_Trabalho2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * @Autowired private UserDetailsServiceImpl userDetailsService;
     * 
     * @Autowired private DataSource dataSource;
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").permitAll().and().logout().permitAll();

        // Outra maneira de fazer

        /**
         * // The pages does not require login http.authorizeRequests().antMatchers("/",
         * "/login", "/logout").permitAll();
         * 
         * // /userInfo page requires login as ROLE_USER or ROLE_ADMIN. // If no login,
         * it will redirect to /login page.
         * http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER',
         * 'ROLE_ADMIN')");
         * 
         * // For ADMIN only.
         * http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
         * 
         * // When the user has logged in as XX. // But access a page that requires role
         * YY, // AccessDeniedException will be thrown.
         * http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
         * 
         * // Config for Login Form http.authorizeRequests().and().formLogin()// //
         * Submit URL of login page. .loginProcessingUrl("/j_spring_security_check") //
         * Submit URL .loginPage("/login")// .defaultSuccessUrl("/userAccountInfo")//
         * .failureUrl("/login?error=true")// .usernameParameter("username")//
         * .passwordParameter("password") // Config for Logout Page
         * .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
         * 
         * // Config Remember Me. http.authorizeRequests().and() //
         * .rememberMe().tokenRepository(this.persistentTokenRepository()) //
         * .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
         * 
         */
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}