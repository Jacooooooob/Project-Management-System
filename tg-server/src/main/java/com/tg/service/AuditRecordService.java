package com.tg.service;

import com.tg.entity.AuditRecord;
import java.util.List;

public interface AuditRecordService {
    /**
     * 添加审核记录
     * @param auditRecord
     */
    void addAuditRecord(AuditRecord auditRecord);

    /**
     * 获取特定项目的审核记录列表
     * @param projectId
     * @return
     */
    List<AuditRecord> findAuditRecordsByProjectId(Long projectId);

    // TODO: 可根据需要添加更多相关的方法，例如更新和删除审核记录等。
}
