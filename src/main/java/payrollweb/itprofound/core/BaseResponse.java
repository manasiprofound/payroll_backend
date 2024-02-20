package payrollweb.itprofound.core;

import org.springframework.http.HttpStatus;


public class BaseResponse<S, T> {
	
	private S status;
	private String message;
	private T data;
	private boolean success;
	
	public S getStatus() {
		return status;
	}
	public void setStatus(S status) {
		this.status = status;
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
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public BaseResponse<HttpStatus, ValidationErrorResponse> prepareResponse(boolean isSuccess, String message, ValidationErrorResponse error, HttpStatus status) {
		BaseResponse<HttpStatus, ValidationErrorResponse> responseJson = new BaseResponse<>();
		responseJson.setSuccess(isSuccess);
		responseJson.setMessage(message);
		responseJson.setData(error);
		responseJson.setStatus(status);
		return responseJson;
	}

}
