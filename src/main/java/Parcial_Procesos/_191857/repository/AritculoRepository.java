package Parcial_Procesos._191857.repository;

import Parcial_Procesos._191857.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AritculoRepository extends JpaRepository <Articulo, Long> {
List <Articulo> findAllByNombre(String Nombre);
}
