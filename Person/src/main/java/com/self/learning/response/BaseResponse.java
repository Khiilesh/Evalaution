package com.self.learning.response;

public class BaseResponse {
	private String status;
	private Integer exitCode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the exitCode
	 */
	public Integer getExitCode() {
		return exitCode;
	}

	/**
	 * @param exitCode the exitCode to set
	 */
	public void setExitCode(Integer exitCode) {
		this.exitCode = exitCode;
	}

	
}
