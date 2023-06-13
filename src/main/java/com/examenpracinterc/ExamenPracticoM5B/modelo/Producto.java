/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenpracinterc.ExamenPracticoM5B.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author chris
 */
@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Size(min = 10, max = 100, message = "La descripcion debe tener entre 10 y un maximo de 100 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "El precio no puede estar en blanco")
    @DecimalMin(value = "0", inclusive = false, message = "El precio debe ser mayor a 0")
    @Column(name = "precio")
    private double precio;

    @NotNull(message = "La cantidad del producto no puede estar en blanco")
    @Positive(message = "La cantidad debe ser mayor a 0")
    @Column(name = "cantidad")
    private int cantidad;

    @NotBlank(message = "El subtotal no puede estar en blanco")
    @Column(name = "subtotal")
    private double subtotal;

     @NotBlank(message = "El descuento no puede estar en blanco")
    @Column(name = "descuento")
    private double descuento;

    @NotBlank(message = "El iva del producto no puede estar en blanco")
    @Column(name = "iva")
    private double iva;

    @NotBlank(message = "El pvp del producto no puede estar en blanco")
    @Column(name = "pvp")
    private double pvp;

}
