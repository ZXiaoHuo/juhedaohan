package com.zqh.juhedaohan.service.type;

import com.zqh.juhedaohan.entity.TypeEntity;
import com.zqh.juhedaohan.repository.type.TypeRepository;
import com.zqh.juhedaohan.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/7/26 0026 21:21
 */
@Service
public interface TypeService extends BaseService<TypeRepository, TypeEntity,Long> {
}
