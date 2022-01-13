package com.bezkoder.spring.jpa.postgresql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Page")
public class GwPage<T> extends BaseResultDTO {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -3669493361703459444L;

	@Schema(description = "Element Count of the Current page")
	private int size;

	@Schema(description = "Total Page Count")
	private int totalPages;

	@Schema(description = "Total Element Count")
	private long totalElements;

	@Schema(description = "Content list")
	private List<T> content = new ArrayList<T>();

	public void addElement(T t) {
		content.add(t);
	}
	

}
