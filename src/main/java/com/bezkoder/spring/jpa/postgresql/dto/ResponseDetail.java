package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
//@ApiModel(description = "ResponseDetail")
public class ResponseDetail implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7071212070421675661L;

//    @ApiModelProperty(value = "Error Detail")
    private List<MessageDetail> errorDetail;

//    @ApiModelProperty(value = "Warning Detail")
    private List<MessageDetail> warningDetail;

//    @ApiModelProperty(value = "Validation Detail")
    private List<MessageDetail> validationDetail;

//    @ApiModelProperty(value = "Info Detail")
    private List<MessageDetail> infoDetail;

//    @ApiModelProperty(value = "Success Detail")
    private List<MessageDetail> successDetail;

//    @ApiModelProperty(value = "Trace Id")
    private String traceId;

//    @ApiModelProperty(value = "Tx Id")
    public String txId;
}