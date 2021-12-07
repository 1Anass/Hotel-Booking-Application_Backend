package ma.hotelbookingapp.monolithic.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active as enabled from user_ where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authority where username = ?");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        

        http.authorizeRequests()
        .antMatchers("/rest/user/admin").hasRole("SUPERADMIN")

        .antMatchers("/rest/user/authenticate").permitAll()

        .antMatchers("/rest/price/suggestion").hasRole("PROVIDER")

        .antMatchers(HttpMethod.GET, "/rest/search/**").permitAll()

        .antMatchers("/rest/search/**").hasAnyRole("ADMIN", "PROVIDER")

        .and().addFilter(new JWTInterceptingFilter()).sessionManagement()

        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
