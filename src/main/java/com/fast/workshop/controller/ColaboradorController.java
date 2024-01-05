package com.fast.workshop.controller;

import com.fast.workshop.model.Colaborador;
import com.fast.workshop.model.Workshop;
import com.fast.workshop.services.ColaboradorService;
import com.fast.workshop.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private WorkshopService workshopService;

    @PostMapping
    public Colaborador adicionar (@RequestBody Colaborador colaborador) {
        return colaboradorService.adicionar(colaborador);
    }

    @GetMapping
    public List<Colaborador> obterTodos() {
        return colaboradorService.obterTodos();
    }

    @GetMapping("/{id}")
    public Colaborador obterPorId (@PathVariable Integer id) {
        return colaboradorService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Integer id){
        colaboradorService.deletar(id);
    }

    @PutMapping("/{id}")
    public Colaborador atualizar (@PathVariable Integer id, Colaborador colaborador) {

        return colaboradorService.atualizar(id, colaborador);
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<Colaborador>> obterColaboradoresOrdenados() {
        List<Colaborador> colaboradoresOrdenados = colaboradorService.obterTodos();

        colaboradoresOrdenados.forEach(colaborador -> {
            List<Workshop> workshopsDoColaborador = workshopService.obterWorkshopsDoColaborador(colaborador.getIdColaborador());
            colaborador.setWorkshops(workshopsDoColaborador);
        });

        colaboradoresOrdenados.sort(Comparator.comparing(Colaborador::getNome));

        return ResponseEntity.ok(colaboradoresOrdenados);
    }

}
