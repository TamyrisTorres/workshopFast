package com.fast.workshop.controller;

import com.fast.workshop.model.Workshop;
import com.fast.workshop.services.WorkshopService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
@Api(value = "Workshops")
@CrossOrigin(origins = "*")
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
    public Workshop obterPorId(Integer id) {
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

    @PutMapping("/{workshopId}/{colaboradorId}")
    public void adicionarColaborador(
            @PathVariable Integer workshopId, @PathVariable Integer colaboradorId) {

         workshopService.adicionarColaborador(
                workshopId, colaboradorId);
    }

}
