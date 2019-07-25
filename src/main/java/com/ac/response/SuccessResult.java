package com.ac.response;

/**
 * @author JIN
 */
public class SuccessResult<T> extends Result<T> {
	private static final long serialVersionUID = -5022829730590439481L;

	public SuccessResult(String message, T data) {
		super(Status.OK, message, data);
	}

	public SuccessResult(T data) {
		this(null, data);
	}
}
