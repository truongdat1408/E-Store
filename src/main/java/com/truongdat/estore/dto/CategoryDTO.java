package com.truongdat.estore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;

    private String name;

    private String slug;

    private Integer sorting;
}
