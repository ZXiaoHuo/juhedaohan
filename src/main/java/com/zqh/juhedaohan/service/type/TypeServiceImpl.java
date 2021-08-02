package com.zqh.juhedaohan.service.type;

import com.zqh.juhedaohan.repository.type.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/7/26 0026 21:22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService{
    private final TypeRepository typeRepository;
    @Override
    public TypeRepository getRepository() {
        return typeRepository;
    }
}
