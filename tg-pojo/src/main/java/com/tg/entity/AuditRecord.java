package com.tg.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 审核记录
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord {

    private Long id;

    private Long projectId;

    private String auditorName;

    private String auditStatus;

    private String comments;

    private LocalDateTime auditTime;
}