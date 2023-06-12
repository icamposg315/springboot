package com.example.notas.dao;

import com.example.notas.model.Nota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NotaDao implements NotaDaoInter {

    @PersistenceContext
    EntityManager conexion;

    @Override
    public List<Nota> listadoNotas() {
        String query = "FROM Nota";
        return conexion.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Nota notas = conexion.find(Nota.class, id);

        conexion.remove(notas);
    }

    @Override
    public void add(Nota notas) {
        conexion.merge(notas);
    }

    @Override
    public void editar(int id, int nota) {
        Nota notas = conexion.find(Nota.class, id);
        notas.setNota(nota);
        add(notas);
    }
}
