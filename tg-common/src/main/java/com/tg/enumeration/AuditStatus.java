package com.tg.enumeration;

import lombok.Getter;

/**
 * 审核状态
 */
@Getter
public enum AuditStatus {
    // TODO
    INITIATED("已发起"),
    IN_PROGRESS("审核中"),
    APPROVED("已通过"),
    REJECTED("已拒绝");

    private final String status;

    AuditStatus(String status) {
        this.status = status;
    }
}