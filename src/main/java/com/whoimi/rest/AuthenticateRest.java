package com.whoimi.rest;

import com.whoimi.common.ResultInfo;
import com.whoimi.config.security.AnonymousKimAccess;
import com.whoimi.model.*;
import com.whoimi.repository.mysql.UserInfoJdbcTemplate;
import com.whoimi.repository.oracle.SysLibraryRepository;
import com.whoimi.service.UserInfoService;
import com.whoimi.utils.SecurityKimUtils;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * AuthenticateRest
 *
 * @author whoimi
 * @since 2023-10-12
 **/

@RestController
@CrossOrigin
public class AuthenticateRest {
    //    private final JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserInfoService userInfoService;
    //    private final UserInfoRepositoryDSL userInfoRepositoryDSL;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private UserInfoJdbcTemplate userInfoJdbcTemplate;
    @Resource
    private SysLibraryRepository sysLibraryRepository;


    //    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @GetMapping("/getUserInfo")
    public ResponseEntity<?> getUserInfo() {
        UserKimDetails currentUser = SecurityKimUtils.getCurrentUser();
        return ResponseEntity.ok(ResultInfo.ok(currentUser));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserInfoDTO user) {
        return ResponseEntity.ok(userInfoService.save(user));
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.POST)
    public ResponseEntity<?> currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();
        Object details = authentication.getDetails();
        System.out.println(authorities);
        System.out.println(principal);
        System.out.println(credentials);
        System.out.println(details);
        return ResponseEntity.ok(authentication);
    }

//    @RequestMapping(value = "/showReplicaStatus", method = RequestMethod.POST)
//    @AnonymousKimAccess
//    public ResponseEntity<?> showReplicaStatus() {
//        List<Map<String, Object>> maps = userInfoService.showReplicaStatus();
//        return ResponseEntity.ok(maps);
//    }

    //    @GetMapping("/page")
//    @AnonymousKimAccess
//    public ResponseEntity<?> page(@QuerydslPredicate(root = UserInfo.class) Predicate predicate, final Pageable pageable) {
//        if (predicate == null) predicate = new BooleanBuilder();
//        Page<UserInfo> dsl = userInfoRepositoryDSL.findAll(predicate, pageable);
//        return ResponseEntity.ok(dsl);
//    }


//    @GetMapping("/dsl")
//    @AnonymousKimAccess
//    public ResponseEntity<?> dsl() {
////        if (predicate == null) predicate = new BooleanBuilder();
//        Optional<UserInfo> userInfo = userInfoRepositoryDSL.queryOne(query -> query
//                .select(userInfoRepositoryDSL.entityProjection())
//                .from(QUserInfo.userInfo)
//                .where(QUserInfo.userInfo.username.in("kinkim", "admin"))
//                .orderBy(QUserInfo.userInfo.realName.asc(), QUserInfo.userInfo.id.asc())
//                .limit(1)
//                .offset(1));
////        Page<UserInfo> dsl = userInfoService.dsl(predicate, pageable);
//        return ResponseEntity.ok(userInfo);
//    }

    @PostMapping(value = "/user/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("SUCCESS");
    }

    @PostMapping(value = "/getInfo")
    public ResponseEntity<?> getInfo() {
        UserInfoDTO us = new UserInfoDTO();
        us.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        us.setEnabled(true);
        us.setIntroduction("I am a super administrator");
        us.setUsername("admin");
        us.setPassword("pwd");
        us.setRoles("admin");
//        path: 'page',
//                component: 'views/permission/page',
//                name: 'PagePermission',
//                meta: {
//                  title: 'Page Permission',
//                    roles: ['admin']
//        }

        MetaVO metaVO1 = new MetaVO("Page Permission", "lock");
        MetaVO metaVO = new MetaVO("PermissionTitle", "lock");
        UserPermissionVO userPermissionVO1 = new UserPermissionVO("PagePermission", "page", "", "permission/page", false, metaVO1, null);
        UserPermissionVO userPermissionVO2 = new UserPermissionVO("RolePermission", "role", "", "permission/role", false, metaVO1, null);
        List<UserPermissionVO> userPermissionVOS = Arrays.asList(userPermissionVO1, userPermissionVO2);
//        UserPermissionVO userPermissionVO = new UserPermissionVO("permission", "/permission", "/permission/page", "Layout", false, metaVO, Collections.singletonList(userPermissionVO1));
        UserPermissionVO userPermissionVO = new UserPermissionVO("permissionName", "/permission", "", "Layout", true, metaVO, userPermissionVOS);
        us.setVo(Collections.singletonList(userPermissionVO));

//        return ResponseEntity.ok(jwtTokenUtil.getCurrentUser());
        return ResponseEntity.ok(us);
    }

}
