package com.bezkoder.spring.jpa.postgresql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Schema(description = "Base Result DTO")
public class BaseResultDTO implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 5570730936485613627L;

	@Schema(description = "Result Code") // 0 = Success, -1 = Failed
	private int resultCode;

	@Schema(description = "Result Message") // 0 = Success, -1 = Failed
	private String resultMessage;

	@Schema(description = "Created User Id")
	private String createUserId;

	@Schema(description = "Creation timestamp")
	private Timestamp createDate;

	@Schema(description = "Delete Y/N")
	private boolean delYn;
	
	public static void success(BaseResultDTO dto) {
		dto.setResultCode(0);
		dto.setResultMessage("Success");
	}
	
	public static void fail(BaseResultDTO dto) {
		dto.setResultCode(-1);
		dto.setResultMessage("Failed");
	}

	public static void fail(BaseResultDTO dto, String resultMessage) {
		dto.setResultCode(-1);
		dto.setResultMessage(resultMessage);
	}

	public static void fail(BaseResultDTO dto,int resultCode, String resultMessage) {
		dto.setResultCode(resultCode);
		dto.setResultMessage(resultMessage);
	}

}
