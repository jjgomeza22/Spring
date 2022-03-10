package com.platzi.market.persistencia.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistencia.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //Se mapea la clase categoria a category para la parte del dominio
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    //Proceso inverso, mapea la clase category a categoria
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) //Ya que la clase categoia esperara un atributo producto de category, pero esta no cuenta con el
    Categoria toCategoria(Category category);
}
