package com.tg.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecordDTO {
    private Long projectId;
    private String auditorName;
    private String auditStatus;
    private String comments;
    private LocalDateTime auditTime;

}
