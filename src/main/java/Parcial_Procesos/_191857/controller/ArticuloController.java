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



}
