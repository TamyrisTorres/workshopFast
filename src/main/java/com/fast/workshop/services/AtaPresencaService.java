package com.fast.workshop.services;

import com.fast.workshop.model.AtaPresenca;
import com.fast.workshop.model.Colaborador;
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
    private ColaboradorRepository colaboradorRepository;

    public AtaPresenca adicionar(AtaPresenca ataPresenca) {
        return ataPresencaRepository.save(ataPresenca);
    }

    public Optional<AtaPresenca> obterPorID(Integer id) {
        return ataPresencaRepository.findById(id);
    }

    public List<AtaPresenca> obterTodos() {
        return ataPresencaRepository.findAll();
    }

    public void deletar(Integer id) {
        ataPresencaRepository.deleteById(id);
    }

    public AtaPresenca atualiza (Integer id, AtaPresenca ataPresenca) {
        ataPresenca.setIdAta(id);

        return ataPresencaRepository.save(ataPresenca);
    }

    public AtaPresenca deletarColaboradorDaAta(Integer idAta, Integer idColaborador) {
        Optional<AtaPresenca> optionalAtaPresenca = ataPresencaRepository.findById(idAta);

        if (optionalAtaPresenca.isEmpty()) {
            throw new NoSuchElementException("Ata não encontrada com ID: " + idAta);
        }

        AtaPresenca ataPresenca = optionalAtaPresenca.get();

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
}
