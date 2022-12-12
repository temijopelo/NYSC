package com.example.NYSC.Service;

import com.example.NYSC.Entity.Address;
import com.example.NYSC.Entity.SavinStudentRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CorperService extends UserDetailsService {
    Address saveCorperDetails(SavinStudentRequest corper);

    Address updateCorperDetails(SavinStudentRequest corper);


    public UserDetails loadUserByUsername(String username);
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }

}
