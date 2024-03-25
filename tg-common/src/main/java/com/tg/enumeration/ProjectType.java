package com.tg.enumeration;

import lombok.Getter;

/**
 * 项目类型
 */
@Getter
public enum ProjectType {
    // TODO
    ENGINEERING_PROJECT("工程项目"),
    RESEARCH_DEVELOPMENT_PROJECT("研发项目");

    private String description;

    ProjectType(String description) {
        this.description = description;
    }
}