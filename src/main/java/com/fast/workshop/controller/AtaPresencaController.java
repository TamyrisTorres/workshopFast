package com.fast.workshop.controller;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.model.Colaborador;
import com.fast.workshop.services.AtaPresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ataPresenca")
public class AtaPresencaController {

    @Autowired
    private AtaPresencaService ataPresencaService;

    @PostMapping
    public AtaPresenca adicionar (@RequestBody AtaPresenca ataPresenca) {
        return ataPresencaService.adicionar(ataPresenca);
    }

    @GetMapping
    public List<AtaPresenca> obterTodos () {
        return ataPresencaService.obterTodos();
    }

    @GetMapping("/{id}")
    public AtaPresenca obterPorId (@PathVariable Integer id) {
        return ataPresencaService.obterPorID(id);
    }

    @GetMapping("/colaboradores/{workshopId}")
    public ResponseEntity<List<Colaborador>> obterColaboradoresWorkshop(@PathVariable Integer workshopId) {
        return ResponseEntity.ok(ataPresencaService.obterColaboradoresWorkshop(workshopId));
    }
    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Integer id) {
        ataPresencaService.deletar(id);
    }

    @PutMapping("/{id}")
    public AtaPresenca atualizar(@RequestBody AtaPresenca ataPresenca, @PathVariable Integer id) {
        return ataPresencaService.atualizar(id, ataPresenca);
    }

    @DeleteMapping("/{ataId}/colaboradores/{colaboradorId}")
    public AtaPresenca removerColaboradorDeAta(@PathVariable Integer ataId, @PathVariable Integer colaboradorId) {
        return ataPresencaService.deletarColaboradorDaAta(ataId, colaboradorId);
    }

    @PutMapping("/{ataId}/{colaboradorId}")
    public AtaPresenca adicionarColaborador(@PathVariable Integer ataId, @PathVariable Integer colaboradorId) {
        return ataPresencaService.adicionarColaborador(ataId, colaboradorId);
    }

}
