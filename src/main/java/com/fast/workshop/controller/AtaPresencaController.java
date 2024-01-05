package com.fast.workshop.controller;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.services.AtaPresencaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<AtaPresenca> obterPorId (@PathVariable Integer id) {
        return ataPresencaService.obterPorID(id);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Integer id) {
        ataPresencaService.deletar(id);
    }

    @PutMapping("/{id}")
    public AtaPresenca atualizar(@RequestBody AtaPresenca ataPresenca, @PathVariable Integer id) {
        return ataPresencaService.atualiza(id, ataPresenca);
    }

    @DeleteMapping("/{ataId}/colaboradores/{colaboradorId}")
    public AtaPresenca removerColaboradorDeAta(@PathVariable Integer ataId, @PathVariable Integer colaboradorId) {
        return ataPresencaService.deletarColaboradorDaAta(ataId, colaboradorId);
    }

}
