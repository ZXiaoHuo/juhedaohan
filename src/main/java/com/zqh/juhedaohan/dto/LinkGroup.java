package com.zqh.juhedaohan.dto;

import com.zqh.juhedaohan.entity.LinkEntity;
import lombok.Data;

import java.util.List;

/**
 * @author zhangqh
 * @date 2021/7/28 0028 9:52
 */
@Data
public class LinkGroup {

    private Long typeId;

    private String typeName;

    private String typeDescribes;

    private List<LinkEntity> links;

}
