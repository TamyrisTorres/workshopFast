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


    public void criarWorkshopComAtaEColaborador(Integer workshopId, Integer colaboradorId, Integer ataId) {
        Workshop workshop = obterPorID(workshopId);

        AtaPresenca ataPresenca = ataPresencaService.obterPorID(ataId);

        ataPresenca.setWorkshop(workshop);

        if (colaboradorId == null) {
            throw new IllegalArgumentException("ID do Colaborador não pode ser nulo");
        }

        Colaborador colaborador = colaboradorService.obterPorId(colaboradorId);

        if (colaborador == null) {
            throw new IllegalArgumentException("Colaborador não encontrado com ID: " + colaboradorId);
        }

        ataPresenca.setColaborador(List.of(colaborador));

        colaboradorService.atualizar(colaborador.getIdColaborador(), colaborador);

        // Associa a AtaPresenca ao Workshop
        workshop.setAtaPresenca(ataPresenca);
        workshopRepository.save(workshop);

    }


    public List<Workshop> obterWorkshopsDoColaborador(Integer idColaborador) {
        Colaborador colaborador = colaboradorService.obterPorId(idColaborador);

        if (colaborador != null) {
            List<Workshop> workshops = new ArrayList<>();

           AtaPresenca ataPresenca = colaborador.getAtasPresenca();
           workshops.add(ataPresenca.getWorkshop());

           return workshops;

        }
        else {
            throw new IllegalArgumentException("Colaborador não encontrado com ID: " + idColaborador);
        }
    }

}
