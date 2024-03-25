package com.tg.enumeration;

import lombok.Getter;

/**
 * 所属行业
 */
@Getter
public enum Industry {
    // TODO
    MANUFACTURING("制造业"),
    IT("信息技术"),
    SERVICE("服务业");
    // ... 其他行业

    private final String industryName;

    Industry(String industryName) {
        this.industryName = industryName;
    }
}