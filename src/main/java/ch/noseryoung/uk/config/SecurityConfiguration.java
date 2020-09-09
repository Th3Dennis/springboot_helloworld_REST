package ch.noseryoung.uk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;





// This class handles basic security concerns
@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/").permitAll();
    }
}

    /*
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/**").hasAuthority("CREATE_USER")
                .antMatchers(HttpMethod.GET, "/users/**").hasAuthority("RETRIEVE_USER")
                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority("UPDATE_USER")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("DELETE_USER")
                .antMatchers(HttpMethod.POST, "/auctions/**").hasAuthority("CREATE_AUCTION")
                .antMatchers(HttpMethod.GET, "/auctions/**").hasAuthority("RETRIEVE_AUCTION")
                .antMatchers(HttpMethod.PUT, "/auctions/**").hasAuthority("UPDATE_AUCTION")
                .antMatchers(HttpMethod.DELETE, "/auctions/**").hasAuthority("DELETE_AUCTION")
                .antMatchers(HttpMethod.POST, "/authorities/**").hasAuthority("CREATE_AUTHORITY")
                .antMatchers(HttpMethod.GET, "/authorities/**").hasAuthority("RETRIEVE_AUTHORITY")
                .antMatchers(HttpMethod.PUT, "/authorities/**").hasAuthority("UPDATE_AUTHORITY")
                .antMatchers(HttpMethod.DELETE, "/authorities/**").hasAuthority("DELETE_AUTHORITY")
                .antMatchers(HttpMethod.POST, "/roles/**").hasAuthority("CREATE_ROLE")
                .antMatchers(HttpMethod.GET, "/roles/**").hasAuthority("RETRIEVE_ROLE")
                .antMatchers(HttpMethod.PUT, "/roles/**").hasAuthority("UPDATE_ROLE")
                .antMatchers(HttpMethod.DELETE, "/roles/**").hasAuthority("DELETE_ROLE")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        //User Role with username, password and authorities
        UserDetails theUser = User.withUsername("yves")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("yves").roles("USER").authorities("RETRIEVE_USER", "RETRIEVE_AUCTION", "RETRIEVE_AUTHORITY", "RETRIEVE_ROLE").build();

        //Manager Role with username, password and authorities
        UserDetails theManager = User.withUsername("dennis")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("dennis").roles("MANAGER")
                .authorities("CREATE_USER", "UPDATE_USER", "RETRIEVE_USER", "DELETE_USER", "CREATE_AUCTION", "RETRIEVE_AUCTION", "UPDATE_AUCTION", "DELETE_AUCTION", "CREATE_AUTHORITY", "RETRIEVE_AUTHORITY", "UPDATE_AUTHORITY", "DELETE_AUTHORITY", "CREATE_ROLE", "RETRIEVE_ROLE", "UPDATE_ROLE", "DELETE_ROLE").build();


        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager);

        return userDetailsManager;
    }
}

     */
