package com.tg.entity;

import lombok.*;


/**
 * 行业
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Industry {

    private Long id;

    private String name;

    private String description;
}
