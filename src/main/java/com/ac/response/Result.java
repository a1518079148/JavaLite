package com.ac.response;

import java.io.Serializable;

/**
 * @author JIN
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -7331756658372098905L;

	private Status status;
	private String message;
	private T data;

	public Result(Status status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public boolean isOk() {
		return Status.OK == status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
