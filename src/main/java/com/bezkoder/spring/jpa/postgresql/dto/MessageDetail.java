package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel(description = "ErrorDetail")
public class MessageDetail implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3612155464509471211L;

//    @ApiModelProperty(value = "Message")
    private String message;

//    @ApiModelProperty(value = "Code")
    private String code;
}
