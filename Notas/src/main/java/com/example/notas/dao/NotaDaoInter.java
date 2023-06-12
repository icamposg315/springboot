package com.example.notas.dao;

import com.example.notas.model.Nota;

import java.util.List;

public interface NotaDaoInter {

    List<Nota> listadoNotas();

    void delete(int id);

    void add(Nota notas);

    void editar(int id, int nota);
}
