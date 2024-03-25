//package com.tg.service.impl;
//
//import com.tg.entity.AuditRecord;
//import com.tg.mapper.AuditRecordMapper;
//import com.tg.service.AuditRecordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class AuditRecordServiceImpl implements AuditRecordService {
//
//    @Autowired
//    private AuditRecordMapper auditRecordMapper;
//
////    @Autowired
////    public AuditRecordServiceImpl(AuditRecordMapper auditRecordMapper) {
////        this.auditRecordMapper = auditRecordMapper;
////    }
//
//    /**
//     * 添加审核记录
//     * @param auditRecord
//     */
//    @Override
//    @Transactional
//    public void addAuditRecord(AuditRecord auditRecord) {
//        auditRecordMapper.insert(auditRecord);
//    }
//
//    /**
//     * 获取特定项目的审核记录列表
//     * @param projectId
//     * @return
//     */
//    @Override
//    @Transactional(readOnly = true)
//    public List<AuditRecord> findAuditRecordsByProjectId(Long projectId) {
//        return auditRecordMapper.findByProjectId(projectId);
//    }
//
//    // TODO: 可实现其他方法，例如更新和删除审核记录
//}
