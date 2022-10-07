package Parcial_Procesos._191857.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(length = 100,nullable = false)
    private String descripcion;

    private String fechaRegitro;

    @Column(length = 100,nullable = false)
    private String categoria;

}
