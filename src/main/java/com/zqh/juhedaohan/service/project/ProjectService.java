package com.zqh.juhedaohan.service.project;

import com.zqh.juhedaohan.entity.ProjectEntity;
import com.zqh.juhedaohan.entity.TypeEntity;
import com.zqh.juhedaohan.repository.project.ProjectRepository;
import com.zqh.juhedaohan.repository.type.TypeRepository;
import com.zqh.juhedaohan.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/9/9 0009 15:00
 */
@Service
public interface ProjectService extends BaseService<ProjectRepository, ProjectEntity,Long> {
}
