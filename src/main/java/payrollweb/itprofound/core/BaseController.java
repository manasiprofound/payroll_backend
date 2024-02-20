package payrollweb.itprofound.core;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

	public <M> ResponseEntity<BaseResponse<HttpStatus, M>> prepareResponse(boolean isSuccess, String message, M data, HttpStatus status) {
		BaseResponse<HttpStatus, M> responseJson = new BaseResponse<>();
		responseJson.setSuccess(isSuccess);
		responseJson.setMessage(message);
		responseJson.setData(data);
		responseJson.setStatus(status);
		return new ResponseEntity<>(responseJson, status);
	}
	
	public <M> ResponseEntity<BaseResponse<HttpStatus, M>> prepareResponse(BaseResponse<HttpStatus, M> responseJson, HttpStatus status) {
		return new ResponseEntity<>(responseJson, status);
	}
	
	public <M> ResponseEntity<BaseResponse<HttpStatus, BasePageResponse<M>>> preparePagedResponse(boolean isSuccess, String message, Page<M> data, HttpStatus status) {
		BaseResponse<HttpStatus, BasePageResponse<M>> responseJson = new BaseResponse<>();
		responseJson.setSuccess(isSuccess);
		responseJson.setMessage(message);
		responseJson.setData(new BasePageResponse<M>(data));
		responseJson.setStatus(status);
		return new ResponseEntity<>(responseJson, status);
}
}
