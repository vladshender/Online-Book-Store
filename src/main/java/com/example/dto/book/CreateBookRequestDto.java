package com.example.dto.book;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    @Size(min = 13, max = 13)
    private String isbn;

    @NotNull
    @DecimalMin(value = "10")
    private BigDecimal price;

    @NotBlank
    private String description;

    @NotBlank
    private String coverImage;
}
