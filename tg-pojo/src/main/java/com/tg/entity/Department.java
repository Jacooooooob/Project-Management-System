package com.tg.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;

    private String name;

    private String description;
}