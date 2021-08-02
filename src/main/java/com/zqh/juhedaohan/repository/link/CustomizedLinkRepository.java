package com.zqh.juhedaohan.repository.link;

import com.zqh.juhedaohan.entity.LinkEntity;

import java.util.List;

/**
 * @author zhangqh
 * @date 2021/7/28 0028 9:07
 */
public interface CustomizedLinkRepository {

    List<LinkEntity> findLinkGroups();

}
