package br.com.natureza.naturezaapi.resources;

import br.com.natureza.naturezaapi.dto.ConfiguracaoDTO;
import br.com.natureza.naturezaapi.dto.NivelDTO;
import br.com.natureza.naturezaapi.exceptions.ObjectNotFoundException;
import br.com.natureza.naturezaapi.models.Configuracao;
import br.com.natureza.naturezaapi.models.Nivel;
import br.com.natureza.naturezaapi.services.ConfiguracaoService;
import br.com.natureza.naturezaapi.services.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/configuracoes")
public class ConfiguracaoResource {

    @Autowired
    ConfiguracaoService service;

    @Transactional(rollbackOn = Exception.class)
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Configuracao> save(@RequestBody ConfiguracaoDTO dto) {
        Configuracao configuracao = service.toEntity(dto);
        configuracao = service.save(configuracao);
        return ResponseEntity.ok().body(configuracao);
    }

   @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ConfiguracaoDTO dto) {
        service.update(dto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Configuracao>> findAll() {
        List<Configuracao> configuracao = service.findAll();
        return ResponseEntity.ok().body(configuracao);
    }

    @RequestMapping(value="/{configuracaoId}", method=RequestMethod.GET)
    public ResponseEntity<Configuracao> findById(@PathVariable Integer configuracaoId) throws ObjectNotFoundException {
        Configuracao configuracao = service.findById(configuracaoId);
        return ResponseEntity.ok().body(configuracao);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody ConfiguracaoDTO dto) {
        Configuracao configuracao = service.findById(dto.getId());
        service.delete(configuracao);
        return ResponseEntity.noContent().build();
    }
}
