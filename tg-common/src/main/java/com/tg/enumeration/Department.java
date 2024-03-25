package com.tg.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 责任部门
 */
@Getter
@AllArgsConstructor
public enum Department {
    BOARD_OF_DIRECTORS(1, "董事会"),
    SENIOR_MANAGEMENT(2, "高级管理层"),
    MARKETING_DEPT_1(3, "营销一部"),
    MARKETING_DEPT_2(4, "营销二部"),
    MARKETING_DEPT_3(5, "营销三部"),
    RND_CENTER(6, "研发中心"),
    ENGINEERING_PROJ_DEPT_1(7, "工程项目一部"),
    ENGINEERING_PROJ_DEPT_2(8, "工程项目二部"),
    ENGINEERING_PROJ_DEPT_3(9, "工程项目三部"),
    ENGINEERING_PROJ_DEPT_4(10, "工程项目四部"),
    ENGINEERING_PROJ_DEPT_5(11, "工程项目五部"),
    ENGINEERING_PROJ_DEPT_6(12, "工程项目六部"),
    DESIGN_DEPT(13, "设计部"),
    PURCHASING_DEPT(14, "采购部"),
    MANUFACTURING_DEPT(15, "制造部"),
    SUPPLY_CHAIN_MGMT_DEPT(16, "供应链管理部"),
    FINANCE_DEPT(17, "财务部"),
    GENERAL_MGMT_DEPT(18, "综合管理部"),
    BOARD_OFFICE(19, "董事会办公室"),
    JIANGXI_YUANGE_CO(20, "江西远格公司(子公司)");

    private final int id;
    private final String name;

//    Department(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }

    // Optional: if you want to get the name by id
    public static String getNameById(int id) {
        for (Department dept : values()) {
            if (dept.getId() == id) {
                return dept.getName();
            }
        }
        return "Unknown";
    }

//    // Optional: if you want to get the enum constant by id
//    public static Department getDepartmentById(int id) {
//        for (Department dept : values()) {
//            if (dept.getId() == id) {
//                return dept;
//            }
//        }
//        return null;
//    }
}
