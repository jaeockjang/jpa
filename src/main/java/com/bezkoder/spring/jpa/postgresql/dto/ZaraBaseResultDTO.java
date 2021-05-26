package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel(description = "ZaraBaseResultDTO")
public class ZaraBaseResultDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3873961442319291111L;

//    @ApiModelProperty(value = "Status")
    private int status;

//    @ApiModelProperty(value = "Code")
    private int code;

//    @ApiModelProperty(value = "Message")
    private String message;

//    @ApiModelProperty(value = "Response Detail")
    private ResponseDetail responseDetail;
}