package com.tg.exception;

/**
 * 项目不存在异常
 */
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String msg) {
        super(msg);
    }
    // 可以根据需要添加更多构造函数或方法
}
