package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

@Data
//@ApiModel(description = "ZTableDTO")
public class ZTableDTO extends ZaraBaseResultDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = -7470860963932069505L;

//    @ApiModelProperty(value = "Result Code") // 0 = Success, -1 = Failed
    private int resultCode;

//    @ApiModelProperty(value = "Result Message") // 0 = Success, -1 = Failed
    private String resultMessage;

    // TODO: 2021-05-10 Delete Object
//    @ApiModelProperty(value = "Return Object")
//    public ReturnObject returnObject = new ReturnObject();

    public static void success(ZTableDTO dto) {
        dto.setResultCode(0);
        dto.setResultMessage("Success");
    }

    public static void fail(ZTableDTO dto) {
        dto.setResultCode(-1);
        dto.setResultMessage("Failed");
    }
}