package com.ac.exception;

import com.ac.response.Status;

/**
 * 自定义异常
 */
public class RException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private Status status = Status.ERROR;

    public RException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RException(String msg, Status status) {
        super(msg);
        this.msg = msg;
        this.status = status;
    }

    public RException(String msg, Status status, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
