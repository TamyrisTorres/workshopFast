package com.fast.workshop.controller;

import com.fast.workshop.model.Colaborador;
import com.fast.workshop.services.ColaboradorService;
import com.fast.workshop.services.WorkshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/Colaborador")
@Api(value = "Colaborador")
@CrossOrigin(origins = "*")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private WorkshopService workshopService;

    @PostMapping
    @ApiOperation(value = "Adiciona um colaborador")
    public Colaborador adicionar (@RequestBody Colaborador colaborador) {
        return colaboradorService.adicionar(colaborador);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de colaboradores")
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

    @GetMapping("/ordenados/{idAta}")
    public ResponseEntity<List<Colaborador>> obterColaboradoresOrdenados(@PathVariable Integer idAta) {
        List<Colaborador> colaboradoresOrdenados = colaboradorService.obterPorIdAtaPresenca(idAta);

        colaboradoresOrdenados.sort(Comparator.comparing(Colaborador::getNome));

        return ResponseEntity.ok(colaboradoresOrdenados);
    }

}
