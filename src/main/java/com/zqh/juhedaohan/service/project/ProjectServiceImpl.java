package com.zqh.juhedaohan.service.project;

import com.zqh.juhedaohan.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangqh
 * @date 2021/9/9 0009 15:00
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;
    @Override
    public ProjectRepository getRepository() {
        return projectRepository;
    }
}
