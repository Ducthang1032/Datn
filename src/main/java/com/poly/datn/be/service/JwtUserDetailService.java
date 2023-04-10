//package com.poly.datn.be.service;
//
//import com.poly.datn.be.domain.UserEntity;
//import com.poly.datn.be.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//public class JwtUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findById(Long.valueOf(userId)).orElse(null);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + userId);
//        }
//        return new User(user.getName(), user.getPassword(), new ArrayList<>());
//    }
//}
