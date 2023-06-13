/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenpracinterc.ExamenPracticoM5B.repository;

import com.examenpracinterc.ExamenPracticoM5B.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
     @Query(value = "Select * from producto u where u.id_producto = :id_producto", nativeQuery = true)
    public Producto buscarProducto(String id_producto);
}
