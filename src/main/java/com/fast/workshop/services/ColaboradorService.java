package com.fast.workshop.services;

import com.fast.workshop.model.Colaborador;
import com.fast.workshop.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador adicionar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador obterPorId (Integer id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);

        return colaborador.get();
    }

    public List<Colaborador> obterTodos() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();

        List<Colaborador> colaboradoresOrdenados = colaboradores.stream()
                .sorted(Comparator.comparing(Colaborador::getNome))
                .collect(Collectors.toList());

        return colaboradoresOrdenados;
    }

    public void deletar (Integer id) {
        colaboradorRepository.deleteById(id);
    }

    public Colaborador atualizar(Integer id, Colaborador colaborador) {
        colaborador.setIdColaborador(id);

        return colaboradorRepository.save(colaborador);
    }
}
