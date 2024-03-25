package com.tg.enumeration;

import lombok.Getter;

/**
 * 项目类别
 */
@Getter
public enum ProjectCategory {
    // TODO
    NEW_DEVELOPMENT("新开发项目"),
    MAINTENANCE("维护项目"),
    UPGRADE("升级项目");

    private final String description;

    ProjectCategory(String description) {
        this.description = description;
    }
}
