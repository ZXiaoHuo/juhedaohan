package com.zqh.juhedaohan.service.login;

import com.querydsl.core.BooleanBuilder;
import com.zqh.juhedaohan.entity.UserEntity;
import com.zqh.juhedaohan.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.zqh.juhedaohan.entity.QUserEntity.userEntity;

/**
 * @author zhangqh
 * @date 2021/8/2 0002 11:14
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;
    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public UserEntity findUserByUserName(String username){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(userEntity.username.eq(username));
        Optional<UserEntity> optional = userRepository.findOne(booleanBuilder);
        return optional.orElse(null);
    }
}
