/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenpracinterc.ExamenPracticoM5B.service;

import com.examenpracinterc.ExamenPracticoM5B.modelo.Producto;
import com.examenpracinterc.ExamenPracticoM5B.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class ProductoServiceImpl  extends GenericServiceImpl<Producto, Integer> implements GenericService<Producto, Integer>{
      @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }    
}


    

