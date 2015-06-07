package org.shahbaz.portal.security.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    DataSource dataSource;

    /**
     * Enabling in-memory user credentials. This will also display a login form
     * by default.
     * 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        /*auth.inMemoryAuthentication()
                .withUser( "user" )
                .password( "password" )
                .roles( "USER" )
                .and()
                .withUser( "admin" )
                .password( "password" )
                .roles( "USER",
                        "ADMIN" );*/

        auth.jdbcAuthentication()
                .dataSource( dataSource )
                .usersByUsernameQuery( "SELECT USERNAME,PASSWORD,'TRUE' AS ENABLED FROM MEMBER WHERE USERNAME = ?" )
                .authoritiesByUsernameQuery( "SELECT MEMBER.USERNAME, MEMBER_ROLE.ROLE AS AUTHORITIES FROM MEMBER,MEMBER_ROLE WHERE MEMBER.USERNAME = ? AND MEMBER.ID=MEMBER_ROLE.MEMBER_ID" );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http.authorizeRequests()
                .antMatchers( "/resources/assets/**",
                              "/signup" )
                .permitAll()
                .antMatchers( "/admin/**" )
                .hasRole( "ADMIN" )
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage( "/login" )
                .permitAll()
                .and()
                .logout()
                .deleteCookies( "JSESSIONID" )
                .invalidateHttpSession( true )
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions( 1 );
    }

    @Override
    public void configure( WebSecurity web ) throws Exception
    {
        web.ignoring().antMatchers( "/resources/**" );
    }
}
