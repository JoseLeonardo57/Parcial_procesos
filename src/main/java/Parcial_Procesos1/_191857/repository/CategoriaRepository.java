package Parcial_Procesos1._191857.repository;

import Parcial_Procesos1._191857.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByCodigo (Long codigo);
}
