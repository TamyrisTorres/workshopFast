package com.fast.workshop.services;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.model.Colaborador;
import com.fast.workshop.model.Workshop;
import com.fast.workshop.repository.AtaPresencaRepository;
import com.fast.workshop.repository.ColaboradorRepository;
import com.fast.workshop.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtaPresencaService {

    @Autowired
    private AtaPresencaRepository ataPresencaRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public AtaPresenca adicionar(AtaPresenca ataPresenca) {
        return ataPresencaRepository.save(ataPresenca);
    }

    public AtaPresenca obterPorID(Integer id) {
        Optional<AtaPresenca> ataPresenca =  ataPresencaRepository.findById(id);

        return ataPresenca.get();
    }

    public List<AtaPresenca> obterTodos() {
        return ataPresencaRepository.findAll();
    }

    public void deletar(Integer id) {
        ataPresencaRepository.deleteById(id);
    }

    public AtaPresenca atualizar (Integer id, AtaPresenca ataPresenca) {
        ataPresenca.setIdAta(id);

        return ataPresencaRepository.save(ataPresenca);
    }

    public AtaPresenca deletarColaboradorDaAta(Integer idAta, Integer idColaborador) {
        AtaPresenca ataPresenca = obterPorID(idAta);

        List<Colaborador> colaboradores = ataPresenca.getColaboradores();

        for (Colaborador colaborador: colaboradores) {
            if (colaborador != null && colaborador.getIdColaborador().equals(idColaborador)) {
                ataPresenca.setColaborador(null);
                ataPresencaRepository.save(ataPresenca);
            }

            ataPresencaRepository.save(ataPresenca);
        }

        return ataPresenca;
    }

    public AtaPresenca adicionarColaborador(Integer idAta, Integer idColaborador) {
        AtaPresenca ataPresenca = obterPorID(idAta);

        Colaborador colaborador = colaboradorService.obterPorId(idColaborador);

        List<Colaborador> colaboradors = colaboradorService.obterTodos();

        colaboradors.add(colaborador);

        ataPresenca.setColaborador(colaboradors);

        colaborador.setAtaPresenca(ataPresenca);

       colaboradorService.atualizar(idColaborador, colaborador);

        return ataPresenca;
    }

    public List<Colaborador> obterColaboradoresWorkshop(Integer workshopId) {
       Optional<Workshop> workshopOptional = workshopRepository.findById(workshopId);

       if (workshopOptional.isPresent()) {
           Workshop workshop = workshopOptional.get();

           AtaPresenca ataPresenca = workshop.getAtaPresenca();

           return ataPresenca.getColaboradores();
       }
       else {
           throw new RuntimeException();
       }
    }
}
