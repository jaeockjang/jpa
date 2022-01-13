package com.bezkoder.spring.jpa.postgresql.domain;

import com.bezkoder.spring.jpa.postgresql.database.entity.BookEntity;
import com.bezkoder.spring.jpa.postgresql.dto.BaseResultDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse extends BaseResultDTO {
    private Long id;
    private String title;

    public static BookResponse toBookResponse(BookEntity entity) {
        return BookResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
