package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel(description = "Base Result DTO")
public class BaseResultDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5570730936485613627L;

//    @ApiModelProperty(value = "Result Code") // 0 = Success, -1 = Failed
    private int resultCode;

//    @ApiModelProperty(value = "Result Message") // 0 = Success, -1 = Failed
    private String resultMessage;

//    @ApiModelProperty(value = "Created User Id")
    private String createUserId;

//    @ApiModelProperty(value = "Creation timestamp")
    private String createDate;

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
