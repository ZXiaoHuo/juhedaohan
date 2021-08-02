package com.zqh.juhedaohan.service.search;

import com.zqh.juhedaohan.entity.SearchEntity;
import com.zqh.juhedaohan.repository.search.SearchRepository;
import com.zqh.juhedaohan.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/7/29 0029 9:00
 */
@Service
public interface SearchService extends BaseService<SearchRepository, SearchEntity,Long> {
}
