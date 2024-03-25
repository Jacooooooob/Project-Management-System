package com.tg.entity;

import lombok.*;
import net.sf.jsqlparser.schema.Table;
import org.apache.xmlbeans.impl.piccolo.xml.Entity;

/**
 * 文档
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private Long id;

    private Long projectId;

    private String documentType;

    private String documentUrl;

    private String description;
}
