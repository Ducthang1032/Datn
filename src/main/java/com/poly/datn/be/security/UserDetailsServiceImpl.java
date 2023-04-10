package com.poly.datn.be.security;

import com.poly.datn.be.constants.AuthoritiesConstants;
import com.poly.datn.be.domain.UserEntity;
import com.poly.datn.be.enums.RoleAccount;
import com.poly.datn.be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(Long.valueOf(userId)).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userId);
        }
        return new User(user.getName(), user.getPassword(), new ArrayList<>());
    }

//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        //Checking in the db
//        UserEntity user = userRepository.getUserEntityById(Long.valueOf(userId));
//        if (Objects.isNull(user))
//            return null;
//
//        // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
//        // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList(AuthoritiesConstants.ROLE_PREFIX.concat(RoleAccount.USER.getName()));
//
//        // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
//        // And used by auth manager to verify and check user authentication.
//        return new User(String.valueOf(user.getId()), user.getPassword(), grantedAuthorities);
//
//    }
}