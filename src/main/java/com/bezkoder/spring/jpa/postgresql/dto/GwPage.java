package com.bezkoder.spring.jpa.postgresql.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
//@ApiModel(description = "Page")
public class GwPage<T> extends ZTableDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = -3669493361703459444L;

//    @ApiModelProperty(value = "Element Count of the Current page")
    private int size;

//    @ApiModelProperty(value = "Total Page Count")
    private int totalPages;

//    @ApiModelProperty(value = "Total Element Count")
    private long totalElements;

//    @ApiModelProperty(value = "Content list")
    private List<T> content = new ArrayList<T>();

    public void addElement(T t) {
        content.add(t);
    }

    private Map<String, Integer> connectionStatusMap = new HashMap<String, Integer>();
}