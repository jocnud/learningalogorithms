package org.shahbaz.portal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController
{
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public String welocme( Model model )
    {

        return "welcome";
    }

    @RequestMapping( value = "/home", method = RequestMethod.GET )
    public String home( Model model )
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if( auth.getAuthorities().contains( new SimpleGrantedAuthority( "ROLE_ADMIN" ) ) )
        {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            System.out.println( userDetails.getUsername() );
            model.addAttribute( "showAdminLink",
                                "true" );
        }
        return "home";
    }

    @RequestMapping( value = "/admin", method = RequestMethod.GET )
    public String admin( Model model )
    {

        return "admin";
    }
}