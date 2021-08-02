package com.zqh.juhedaohan.repository.link;

import com.querydsl.jpa.JPQLQuery;
import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.entity.QTypeEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.zqh.juhedaohan.entity.QLinkEntity.linkEntity;
import static com.zqh.juhedaohan.entity.QTypeEntity.typeEntity;

/**
 * @author zhangqh
 * @date 2021/7/28 0028 9:08
 */
public class CustomizedLinkRepositoryImpl extends QuerydslRepositorySupport implements CustomizedLinkRepository{

    public CustomizedLinkRepositoryImpl() {
        super(LinkEntity.class);
    }

    @Override
    public List<LinkEntity> findLinkGroups() {
        JPQLQuery<LinkEntity> query = getQuerydsl().createQuery()
                .select(linkEntity)
                .from(linkEntity)
                .where(linkEntity.enabled.eq(true)
                        .and(linkEntity.type.enabled.eq(true)))
                .orderBy(linkEntity.type.sort.desc())
                .orderBy(linkEntity.type.id.asc())
                .orderBy(linkEntity.sort.desc());
        return query.fetch();

    }
}
