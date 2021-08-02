package com.zqh.juhedaohan.dto;


import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页查询结果
 * @param <T>
 */
public class PageResponse<T> {

	private final long total;

    /**
     * 本页内容
     */
    @Getter
	private final List<T> content = new ArrayList<>();

    private final Pageable pageable;

	public PageResponse(List<T> content){
		this(content, Pageable.unpaged(), null == content ? 0 : content.size());
	}

	public PageResponse(List<T> content, Pageable pageable, long total) {
        this.content.addAll(content);
        this.pageable = pageable;
        this.total = total;
	}

    /*public PageResponse(List<T> content,Map<String,Object> dict, Pageable pageable, long total) {
        this.content.put("listData",content);
        this.content.put("dict",dict);
        this.pageable = pageable;
        this.total = total;
    }*/

    public static <T> PageResponse<T> empty(Pageable pageable) {
        return new PageResponse<>(Collections.emptyList(), pageable, 0);
    }

    /**
     * 总页数
     */
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    /**
     * 总数
     */
    public long getTotalElements() {
        return total;
    }


    /**
     * 每页大小
     */
    public int getSize() {
        return pageable.isPaged() ? pageable.getPageSize() : content.size();
    }


    /**
     * 当前页码，0开始
     */
    public int getNumber() {
        return pageable.isPaged() ? pageable.getPageNumber() : 0;
    }
}
