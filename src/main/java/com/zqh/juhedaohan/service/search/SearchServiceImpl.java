package com.zqh.juhedaohan.service.search;

import com.zqh.juhedaohan.repository.search.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/7/29 0029 9:02
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final SearchRepository searchRepository;

    @Override
    public SearchRepository getRepository() {
        return searchRepository;
    }
}
