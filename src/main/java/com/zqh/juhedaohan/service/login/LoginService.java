package com.zqh.juhedaohan.service.login;

import com.zqh.juhedaohan.entity.UserEntity;
import com.zqh.juhedaohan.repository.user.UserRepository;
import com.zqh.juhedaohan.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/8/2 0002 11:11
 */
@Service
public interface LoginService extends BaseService<UserRepository, UserEntity,Long> {

    UserEntity findUserByUserName(String username);
}
