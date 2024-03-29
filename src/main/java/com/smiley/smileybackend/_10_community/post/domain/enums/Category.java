package com.smiley.smileybackend._10_community.post.domain.enums;

import lombok.Getter;

/**
 * 카테고리별로 게시글을 분류하기 위한 enum
 */
@Getter
public enum Category {

    ALL("ALL"),
    USER("USER"),
    ADMIN("ADMIN");

    private final String categoryType;
    Category(String categoryType) {
        this.categoryType = categoryType;
    }
}
