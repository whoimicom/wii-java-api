package com.whoimi.config.security;

import jakarta.annotation.Resource;
import com.whoimi.model.UserInfo;
import com.whoimi.repository.mysql.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author whoimi
 * @since 2023-10-12
 **/
@Service
public class UserDetailsServiceKimImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceKimImpl.class);

    @Resource
    private UserInfoRepository userInfoRepository;



/*    @Override
    public Mono<UserDetails> findByUsername(String username) throws UsernameNotFoundException {
        Mono<AppUser> userMono = appUserRepository.findByUsername(username);
        return userMono.map(appUser -> new UserDetailsImpl(appUser.getUsername(), appUser.getPassword(),
                Optional.ofNullable(appUser.getAuthorities())
                        .map(SimpleGrantedAuthority::new)
                        .map(Collections::singletonList).orElse(Collections.EMPTY_LIST)));

    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        log.debug(userInfo.toString());
        String authorities = "/admin,/test,/devople,/app/bills,/app/bills/getBills,RULE_ADMIN";
        String password = userInfo.getPassword();
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(authorities.split(","));
/*        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String permissionCode : authorities.split(",")) {
            if (permissionCode != null && !permissionCode.isEmpty()) {
                GrantedAuthority grantedAuthority =
                        new SimpleGrantedAuthority(permissionCode);
                authorityList.add(grantedAuthority);
            }
        }*/
        return new UserDetailsKimImpl(username, password, authorityList);
    }
}
