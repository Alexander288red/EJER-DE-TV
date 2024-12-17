/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ventas.controller;

import com.example.ventas.model.Televisor;
import com.example.ventas.servicio.TelevisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/televisores")
public class TelevisorController {

    private final TelevisorService service;

    public TelevisorController(TelevisorService service) {
        this.service = service;
    }

    @GetMapping
    public String listarTelevisores(Model model) {
        model.addAttribute("televisores", service.listarTodos());
        return "listado_televisores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("televisor", new Televisor());
        return "formulario_televisor";
    }

    @PostMapping
    public String guardarTelevisor(@ModelAttribute Televisor televisor) {
        service.guardar(televisor);
        return "redirect:/televisores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("televisor", service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID invalido " + id)));
        return "formulario_televisor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTelevisor(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/televisores";
    }
}