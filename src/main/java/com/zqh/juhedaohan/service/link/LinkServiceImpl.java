package com.zqh.juhedaohan.service.link;

import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.repository.link.LinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangqh
 * @date 2021/7/27 0027 17:09
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService{

    private final LinkRepository linkRepository;

    @Override
    public LinkRepository getRepository() {
        return linkRepository;
    }

    @Override
    public List<LinkEntity> findLinksOrderByTypeId() {
        return linkRepository.findLinkGroups();
    }
}
