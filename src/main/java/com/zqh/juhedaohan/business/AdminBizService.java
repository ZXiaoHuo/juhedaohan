package com.zqh.juhedaohan.business;

import com.querydsl.core.BooleanBuilder;
import com.zqh.juhedaohan.entity.*;
import com.zqh.juhedaohan.service.link.LinkService;
import com.zqh.juhedaohan.service.project.ProjectService;
import com.zqh.juhedaohan.service.search.SearchService;
import com.zqh.juhedaohan.service.type.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.zqh.juhedaohan.entity.QTypeEntity.typeEntity;

/**
 * @author zhangqh
 * @date 2021/7/26 0026 21:19
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminBizService {
    private final TypeService typeService;
    private final LinkService linkService;
    private final SearchService searchService;
    private final ProjectService projectService;

    public List<TypeEntity> findTypeList() {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(typeEntity.enabled.eq(true));
        return typeService.findAll(booleanBuilder);
    }

    public TypeEntity findTypeById(Long id) throws Exception {
        return typeService.findById(id).orElseThrow(Exception::new);
    }

    public LinkEntity findLinkById(Long id) throws Exception {
        return linkService.findById(id).orElseThrow(Exception::new);
    }

    public SearchEntity findSearchById(Long id) throws Exception {
        return searchService.findById(id).orElseThrow(Exception::new);
    }

    public ProjectEntity findProjectById(Long id) throws Exception {
        return projectService.findById(id).orElseThrow(Exception::new);
    }

    public Page<TypeEntity> findTypeByPage(Pageable pageable) {
        return typeService.findAll(pageable);
    }

    public Page<LinkEntity> findLinkByPage(Pageable pageable) {
        return linkService.findAll(pageable);
    }

    public Page<SearchEntity> findSearchByPage(Pageable pageable) {
        return searchService.findAll(pageable);
    }

    public Page<ProjectEntity> findProjectByPage(Pageable pageable) {
        return projectService.findAll(pageable);
    }

    @Transactional
    public void addType(TypeEntity typeEntity) {
        typeService.save(typeEntity);
    }

    @Transactional
    public void addOrUpdateType(TypeEntity typeEntity) throws Exception {
        if (typeEntity.getId() != null) {
            TypeEntity typeById = findTypeById(typeEntity.getId());
            typeEntity.setCreateTime(typeById.getCreateTime());
        }
        typeService.save(typeEntity);
    }

    @Transactional
    public void addOrUpdateLink(LinkEntity linkEntity) throws Exception {
        if (linkEntity.getId() != null) {
            LinkEntity linkById = findLinkById(linkEntity.getId());
            linkEntity.setCreateTime(linkById.getCreateTime());
        }
        TypeEntity typeById = findTypeById(linkEntity.getType().getId());
        linkEntity.setType(typeById);
        linkService.save(linkEntity);
    }

    @Transactional
    public void addOrUpdateSearch(SearchEntity searchEntity) throws Exception {
        if (searchEntity.getId() != null) {
            SearchEntity searchById = findSearchById(searchEntity.getId());
            searchEntity.setCreateTime(searchById.getCreateTime());
        }
        searchService.save(searchEntity);
    }

    @Transactional
    public void addOrUpdateProject(ProjectEntity projectEntity) throws Exception {
        if (projectEntity.getId() != null) {
            ProjectEntity projectById = findProjectById(projectEntity.getId());
            projectEntity.setCreateTime(projectById.getCreateTime());
        }
        projectService.save(projectEntity);
    }
}
