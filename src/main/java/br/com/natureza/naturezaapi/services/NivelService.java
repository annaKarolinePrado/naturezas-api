package br.com.natureza.naturezaapi.services;

import br.com.natureza.naturezaapi.dto.NivelDTO;
import br.com.natureza.naturezaapi.exceptions.ObjectNotFoundException;
import br.com.natureza.naturezaapi.models.Nivel;
import br.com.natureza.naturezaapi.repositories.NivelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    public Nivel save(Nivel nivel) {
        nivel.setId(null);
        return nivelRepository.save(nivel);
    }
    public Nivel toEntity(NivelDTO dto) {
        Nivel nivel = new Nivel();
        nivel.setDescricao(dto.getDescricao());
        nivel.setDigito(dto.getDigito());
        nivel.setNumero(dto.getNumero());
        nivel.setSeparador(dto.getSeparador());
        nivel.setNivel(dto.getNivel());
        return nivel;
    }
    public List<Nivel> findAll() throws ObjectNotFoundException {
        return nivelRepository.findAll();
    }
    public Nivel findById(Integer nivelId ) throws ObjectNotFoundException {
        Optional<Nivel> nivel = nivelRepository.findById(nivelId);
        return nivel.orElseThrow(() -> new ObjectNotFoundException("Nivel não encontrado."));
    }
}
