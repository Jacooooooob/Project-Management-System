package com.tg.enumeration;

import lombok.Getter;

/**
 * 产品类型
 */
@Getter
public enum ProductType {
    // TODO
    CONSUMER_ELECTRONICS("消费电子"),
    INDUSTRIAL_EQUIPMENT("工业设备"),
    SOFTWARE("软件产品");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }
}