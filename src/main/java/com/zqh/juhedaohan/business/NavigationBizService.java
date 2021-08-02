package com.zqh.juhedaohan.business;

import com.querydsl.core.BooleanBuilder;
import com.zqh.juhedaohan.dto.LinkGroup;
import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.entity.SearchEntity;
import com.zqh.juhedaohan.service.link.LinkService;
import com.zqh.juhedaohan.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zqh.juhedaohan.entity.QLinkEntity.linkEntity;
import static com.zqh.juhedaohan.entity.QSearchEntity.searchEntity;


/**
 * 巨和刀汉
 * @author zhangqh
 * @date 2021/7/27 0027 17:35
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NavigationBizService {

    private final LinkService linkService;
    private final SearchService searchService;

    public List<LinkEntity> findLinks() {

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(linkEntity.enabled.eq(true));
        return linkService.findAll(booleanBuilder);

    }

    /*
     * List<Map<String,List<LinkEntity>>>
     */
    public List<LinkGroup> findLinkGroups() {
        List<LinkEntity> linksOrderByTypeId = linkService.findLinksOrderByTypeId();
        long typeId = 0;
        List<LinkGroup> result = new ArrayList<>();
        LinkGroup linkGroup = null;
        List<LinkEntity> links = null;
        LinkEntity preLink = null;
        for (LinkEntity link: linksOrderByTypeId) {
            if (link.getType().getId()!=typeId) {
                //先把上一组存起来
                if (linkGroup != null) {
                    linkGroup.setTypeId(typeId);
                    linkGroup.setTypeName(preLink.getType().getName());
                    linkGroup.setTypeDescribes(preLink.getType().getDescribes());
                    linkGroup.setLinks(links);
                    result.add(linkGroup);
                }
                //发现新的链接组（按链接类型分组）
                typeId = link.getType().getId();
                linkGroup = new LinkGroup();
                links = new ArrayList<>();
            }
            preLink = link;
            links.add(link);

        }
        linkGroup.setTypeId(typeId);
        linkGroup.setTypeName(preLink.getType().getName());
        linkGroup.setTypeDescribes(preLink.getType().getDescribes());
        linkGroup.setLinks(links);
        result.add(linkGroup);
        return result;
    }

    public List<SearchEntity> findSearchList() {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(searchEntity.enabled.eq(true));
        return searchService.findAll(booleanBuilder, Sort.by(Sort.Direction.DESC,"sort"));
    }
}
