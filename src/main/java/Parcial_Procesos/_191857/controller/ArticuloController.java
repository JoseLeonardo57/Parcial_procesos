package Parcial_Procesos._191857.controller;

import Parcial_Procesos._191857.model.Articulo;
import Parcial_Procesos._191857.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticuloController {

    @Autowired
    private ArticuloRepository ArticuloRepository;


    @GetMapping(value = "/articulo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable Long codigo){
        Optional<Articulo> articulo= ArticuloRepository.findById(codigo);
        if(articulo.isPresent()){
            return new ResponseEntity(articulo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping(value = "/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        try {
            ArticuloRepository.save(articulo);
            return new ResponseEntity(articulo,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping(value = "/articulo")
    public ResponseEntity listarArticulo(){
        List<Articulo> articulos = ArticuloRepository.findAll();
        if (articulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(articulos,HttpStatus.OK);
    }


    @PutMapping("/articulo/{codigo}")
    public ResponseEntity editarArticulo(@PathVariable Long id, @RequestBody Articulo articulo){
        Optional<Articulo> articuloBD = ArticuloRepository.findById(id);
        if (articuloBD.isPresent()){
            try {
                articuloBD.get().setNombre(articulo.getNombre());
                articuloBD.get().setDescripcion(articulo.getDescripcion());
                articuloBD.get().setFechaRegistro(articulo.getFechaRegistro());
                articuloBD.get().setCategoria(articulo.getCategoria());
                articuloBD.get().setPrecioVenta(articulo.getPrecioVenta());
                articuloBD.get().setPrecioCompra(articulo.getPrecioCompra());
                ArticuloRepository.save(articuloBD.get());
                return new ResponseEntity(articuloBD,HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable Long codigo){
        Optional<Articulo> articuloBD = ArticuloRepository.findById(codigo);
        if (articuloBD.isPresent()){
            ArticuloRepository.delete(articuloBD.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
