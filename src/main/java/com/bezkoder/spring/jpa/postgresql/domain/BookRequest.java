package com.bezkoder.spring.jpa.postgresql.domain;

import com.bezkoder.spring.jpa.postgresql.database.entity.BookEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Equipment Model Parameter")
public class BookRequest {

    @Schema(description = "Request a page number. Fisrt page number is 0.", required = false, example = "0")
    private int page=0;

    @Schema(description = "Request number of data per page.", required = false, example = "10")
    private int size=10;

    private String title;

    public BookEntity toBookEntity() {
        return BookEntity.builder()
                .title(title)
                .build();
    }
}
