package com.killer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {


    private Integer idCategory;
    //al usar validadores el controlador debe usar la notacion @Valid por delante de @RequestBody
    @NotNull
    @NotEmpty
    @Size(min=3,max = 50)
    private String nameCategory;

    @NotNull
    @NotEmpty
    @Size(min=3,max = 50)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;
}
