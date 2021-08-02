package com.zqh.juhedaohan.service.link;

import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.repository.link.LinkRepository;
import com.zqh.juhedaohan.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangqh
 * @date 2021/7/27 0027 17:09
 */
@Service
public interface LinkService extends BaseService<LinkRepository, LinkEntity, Long> {

    List<LinkEntity> findLinksOrderByTypeId();
}
