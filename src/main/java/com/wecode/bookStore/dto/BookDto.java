package com.wecode.bookStore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description = "All details about book")
public class BookDto {
    
    @ApiModelProperty(
            value = "UUID",
            dataType = "UUID",
            example = "47e43947-3ecb-4a49-ae13-cca8ee1c3591",
            notes = "The database generated UUID for book id",
            required = true
    )
    private UUID id;
    
    @ApiModelProperty(
            value = "title",
            dataType = "String",
            example = "book title",
            notes = "The book title",
            required = true
    )
    private String title;
    
    @ApiModelProperty(
            value = "description",
            dataType = "String",
            example = "Book description",
            notes = "The book description",
            required = true
    )
    private String description;
    
    @ApiModelProperty(
            value = "releaseYear",
            dataType = "int",
            example = "2020",
            notes = "The release year of the book",
            required = true
    )
    private int releaseYear;
}