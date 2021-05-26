package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel(description="Page paramters")
public class PageParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -272940100682918695L;


//    @ApiModelProperty(value = "Request a page number. Fisrt page number is 0.", required = false, example = "0")
    private int page=0;


//    @ApiModelProperty(value = "Request number of data per page.", required = false, example = "10")
    private int size=10;

//    @ApiModelProperty(value = "The words for search.", required = false, example = "Test word")
    private String searchText;
}
