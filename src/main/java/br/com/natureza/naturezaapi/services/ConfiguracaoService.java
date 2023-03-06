package br.com.natureza.naturezaapi.services;

import br.com.natureza.naturezaapi.dto.ConfiguracaoDTO;
import br.com.natureza.naturezaapi.dto.NivelDTO;
import br.com.natureza.naturezaapi.exceptions.ObjectNotFoundException;
import br.com.natureza.naturezaapi.models.Configuracao;
import br.com.natureza.naturezaapi.models.Nivel;
import br.com.natureza.naturezaapi.repositories.ConfiguracaoRepository;
import br.com.natureza.naturezaapi.repositories.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public Configuracao toEntity(ConfiguracaoDTO dto) {
        Configuracao configuracao = new Configuracao();
        configuracao.setDescricao(dto.getDescricao());
        configuracao.setNiveis(dto.getNiveis());
        return configuracao;
    }

    public Configuracao save(Configuracao configuracao) {
        configuracao.setId(null);
        return configuracaoRepository.save(configuracao);
    }

    public Configuracao findById(Integer configuracaoId ) throws ObjectNotFoundException {
        Optional<Configuracao> configuracao = configuracaoRepository.findById(configuracaoId);
        return configuracao.orElseThrow(() -> new ObjectNotFoundException("Configuração não encontrada."));
    }

    public void delete(Configuracao configuracao){
        configuracaoRepository.deleteById(configuracao.getId());
    }

    public Configuracao update(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }

    public Configuracao update(ConfiguracaoDTO configuracaoDTO) {
        Configuracao configuracao = findById(configuracaoDTO.getId());
        configuracao.setId(configuracaoDTO.getId() == null ? configuracao.getId() : configuracaoDTO.getId());
        configuracao.setDescricao(configuracaoDTO.getDescricao() == null ? configuracao.getDescricao() : configuracaoDTO.getDescricao());
  //      configuracao.setNiveis(configuracaoDTO.get() == null ? configuracao.getNiveis() : configuracaoDTO.get());
        update(configuracao);
        return configuracao;
    }

    public List<Configuracao> findAll() throws ObjectNotFoundException {
        return configuracaoRepository.findAll();
    }
}
