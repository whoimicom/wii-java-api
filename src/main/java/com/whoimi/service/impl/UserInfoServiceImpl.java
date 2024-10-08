package com.whoimi.service.impl;

import com.whoimi.model.UserInfo;
import com.whoimi.model.UserInfoDTO;
import com.whoimi.repository.mysql.UserInfoRepository;
import com.whoimi.service.UserInfoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author whoimi
 * @since 2023-10-12
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;


    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo save(UserInfoDTO dto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(dto.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        userInfo.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    @Override
    public List<Map<String, Object>> showReplicaStatus() {
        return userInfoRepository.showReplicaStatus();
    }
}
