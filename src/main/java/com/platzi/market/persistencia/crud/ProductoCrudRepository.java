package com.platzi.market.persistencia.crud;

import com.platzi.market.persistencia.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto, Integer>{

    //Se puede hacer con la notacion @Query, que indicaria que es un cueri nativo
    //El metodo podria llevar cualquier nombre
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);

    //Es mejor practica usar Query Methods porque ofrece mayor flexibilidad
    List<Producto> findByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}