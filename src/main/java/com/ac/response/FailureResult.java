package com.ac.response;

/**
 * @author JIN
 */
public class FailureResult<T> extends Result<T> {
	private static final long serialVersionUID = -3543933085557881047L;

	public FailureResult(Status status, String message, T data) {
		super(status, message, data);
	}

	public FailureResult(Status status, String message) {
		this(status, message, null);
	}
}
