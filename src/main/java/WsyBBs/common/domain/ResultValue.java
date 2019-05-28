package WsyBBs.common.domain;

import lombok.Data;

@Data
public class ResultValue<T> {

	private T data;
	private Integer code;
	private String message;

	public static final Integer SUCCESS_CODE = 1;

	public static final Integer FALTURE_CODE = 0;

	public ResultValue(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultValue(T data, Integer code) {
		this.data = data;
		this.code = code;
	}

	public ResultValue() {

	}

}
