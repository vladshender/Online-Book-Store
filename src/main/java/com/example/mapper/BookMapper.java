package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.BookDto;
import com.example.dto.CreateBookRequestDto;
import com.example.model.Book;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    List<BookDto> toDtoList(List<Book> books);
}
