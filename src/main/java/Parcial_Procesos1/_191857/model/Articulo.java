package Parcial_Procesos1._191857.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 100)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    private Date fechaRegistro;

    @Column(length = 300)
    private String categoria;

    @Column(length = 300)
    private String precioVenta;

    @Column(length = 300)
    private String precioCompra;

}
