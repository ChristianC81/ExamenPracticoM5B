/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenpracinterc.ExamenPracticoM5B.controlador;

import com.examenpracinterc.ExamenPracticoM5B.modelo.Producto;
import com.examenpracinterc.ExamenPracticoM5B.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Obtendra la lista de Productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Producto")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto u) {
        // Realizar los cálculos necesarios
        double valorVenta = u.getPrecio() * u.getCantidad();
        double descuento = 0;
        double iva = 0;
        if (valorVenta > 50) {
            descuento = valorVenta * 0.1;
        }
        iva = valorVenta * 0.12;
        double totalPagar = valorVenta - descuento + iva;

        // Actualizar los valores en el objeto Producto
        u.setSubtotal(valorVenta);
        u.setDescuento(descuento);
        u.setIva(iva);
        u.setPvp(totalPagar);
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                // Actualizar los valores en el objeto Producto
                producto.setDescripcion(u.getDescripcion());
                producto.setPrecio(u.getPrecio());
                producto.setCantidad(u.getCantidad());

                // Realizar los cálculos necesarios
                double valorVenta = producto.getPrecio() * producto.getCantidad();
                double descuento = 0;
                double iva = 0;
                if (valorVenta > 50) {
                    descuento = valorVenta * 0.1;
                }
                iva = valorVenta * 0.12;
                double totalPagar = valorVenta - descuento + iva;

                producto.setDescripcion(u.getDescripcion());
                producto.setPrecio(u.getPrecio());
                producto.setCantidad(u.getCantidad());
                producto.setSubtotal(u.getSubtotal());
                producto.setDescuento(u.getDescuento());
                producto.setIva(u.getIva());
                producto.setPvp(u.getPvp());
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
