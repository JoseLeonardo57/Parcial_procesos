package Parcial_Procesos1._191857.repository;

import Parcial_Procesos1._191857.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    List<Articulo> findAllByCodigo (Long codigo);
}
