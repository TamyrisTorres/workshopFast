package com.fast.workshop.services;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.model.Colaborador;
import com.fast.workshop.model.Workshop;
import com.fast.workshop.repository.AtaPresencaRepository;
import com.fast.workshop.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private AtaPresencaRepository ataPresencaRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private AtaPresencaService ataPresencaService;

    public Workshop adicionar(Workshop workshop) {
        AtaPresenca ataPresenca = new AtaPresenca();

        ataPresenca.setName(workshop.getNome());

        ataPresenca = ataPresencaRepository.save(ataPresenca);

        workshop.setAtaPresenca(ataPresenca);


        workshop = workshopRepository.save(workshop);

        return workshop;
    }

    public Workshop obterPorID(Integer id) {
        Optional<Workshop> workshop =  workshopRepository.findById(id);

        return workshop.get();
    }

    public List<Workshop> obterTodos() {
        return workshopRepository.findAll();
    }

    public void deletar(Integer id) {
        workshopRepository.deleteById(id);
    }

    public Workshop atualizar (Integer id, Workshop workshop) {
        workshop.setIdWorkshop(id);

      return workshopRepository.save(workshop);
    }


    public void adicionarColaborador(Integer workshopId, Integer colaboradorId) {
        Workshop workshop = obterPorID(workshopId);

        AtaPresenca ataPresenca = workshop.getAtaPresenca();

        if (colaboradorId == null) {
            throw new IllegalArgumentException("ID do Colaborador não pode ser nulo");
        }

        Colaborador colaborador = colaboradorService.obterPorId(colaboradorId);

        if (colaborador == null) {
            throw new IllegalArgumentException("Colaborador não encontrado com ID: " + colaboradorId);
        }

        List<Colaborador> colaboradores = ataPresenca.getColaboradores();

        colaboradores.add(colaboradores.size(), colaborador);

        ataPresenca.setWorkshop(workshop);
        ataPresencaRepository.save(ataPresenca);
        workshop.setAtaPresenca(ataPresenca);

        atualizar(workshopId, workshop);
    }

}
