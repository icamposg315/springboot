package com.example.notas.controller;

import com.example.notas.dao.NotaDaoInter;
import com.example.notas.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    NotaDaoInter notas;

    @GetMapping("/listarNotas")
    public List<Nota> listarNotas() {
        return notas.listadoNotas();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarID(@PathVariable int id) {
        notas.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Nota nota1) {
        notas.add(nota1);
    }

    @PutMapping("/editar/{id}{nota}")
    public void editar(@PathVariable int id, @RequestBody int nota1) {
        notas.editar(id, nota1);
    }
}

