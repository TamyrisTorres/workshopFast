package com.fast.workshop.controller;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.model.Workshop;
import com.fast.workshop.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/workshops")
public class WorkShopController {

    @Autowired
    private WorkshopService workshopService;

    @PostMapping
    public Workshop adicionar (@RequestBody Workshop workshop) {
        return workshopService.adicionar(workshop);
    }

    @GetMapping
    public List<Workshop> obterTodos () {
        return workshopService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Workshop> obterPorId(Integer id) {
        return workshopService.obterPorID(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        workshopService.deletar(id);
    }

    @PutMapping("/{id}")
    public Workshop atualizar(@RequestBody Workshop workshop, @PathVariable Integer id) {
        return workshopService.atualizar(id, workshop);
    }

    @PutMapping("/{workshopId}/atas/{colaboradorId}")
    public Workshop criarWorkshopComAtaEColaborador(@RequestBody Workshop workshop, @PathVariable Integer colaboradorId) {

        return workshopService.criarWorkshopComAtaEColaborador(workshop, colaboradorId);
    }

}
