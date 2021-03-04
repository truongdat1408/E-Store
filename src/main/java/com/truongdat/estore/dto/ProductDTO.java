package com.truongdat.estore.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)

public class ProductDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Min(1)
    private Integer quantity;

    @Min(1)
    private Float price;

    @NotNull
    private Long categoryId;

    private String image;

}
