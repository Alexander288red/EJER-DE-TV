/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ventas.servicio;

import com.example.ventas.model.Televisor;
import com.example.ventas.repositorio.TelevisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisorService {

    @Autowired
    private TelevisorRepository repository;

    public List<Televisor> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Televisor televisor) {
        repository.save(televisor);
    }

    public Optional<Televisor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}