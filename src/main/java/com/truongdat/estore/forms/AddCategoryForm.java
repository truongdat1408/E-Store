package com.truongdat.estore.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddCategoryForm {
    @NotBlank
    private String name;
    @Min(1)
    private Integer sorting;
}
