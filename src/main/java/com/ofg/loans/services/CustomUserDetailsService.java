package com.ofg.loans.services;

import com.ofg.loans.model.Client;
import com.ofg.loans.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 19.04.16.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private ClientService userService;

    public void setUserService(ClientService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Client client = userService.findByUsername(username);
        System.out.println("User : " + client);
        if (client == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(),
                client.getState().equals("Active"), true, true, true, getGrantedAuthorities(client));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Client client) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : client.getUserProfiles()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
