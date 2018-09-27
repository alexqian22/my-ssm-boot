package com.enreach.ssm.infrastructure;



import com.enreach.ssm.utils.DateFormatUtil;

import java.util.Date;

/**
 * 通用错误返回结果集(和 spring boot 默认类似)
 */
public class ErrorResult {
    private String timestamp;
    private int status;
    private String error;
    private Object message;
    private String path;

    public ErrorResult(int status, String error, Object message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = DateFormatUtil.ISO_YMD_HMS_FORMAT.format(new Date());
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
