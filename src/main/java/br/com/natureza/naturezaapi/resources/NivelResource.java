package br.com.natureza.naturezaapi.resources;

import br.com.natureza.naturezaapi.dto.NivelDTO;
import br.com.natureza.naturezaapi.exceptions.ObjectNotFoundException;
import br.com.natureza.naturezaapi.models.Nivel;
import br.com.natureza.naturezaapi.services.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/niveis")
public class NivelResource {

    @Autowired
    NivelService service;

    @Transactional(rollbackOn = Exception.class)
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Nivel> salvar(@RequestBody NivelDTO dto) {
        Nivel nivel = service.toEntity(dto);
        nivel = service.save(nivel);
        return ResponseEntity.ok().body(nivel);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Nivel>> findAll() {
        List<Nivel> niveis = service.findAll();
        return ResponseEntity.ok().body(niveis);
    }

    @RequestMapping(value="/{nivelId}", method=RequestMethod.GET)
    public ResponseEntity<Nivel> findById(@PathVariable Integer nivelId) throws ObjectNotFoundException {
        Nivel nivel = service.findById(nivelId);
        return ResponseEntity.ok().body(nivel);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody NivelDTO dto) {
        Nivel nivel = service.findById(dto.getId());
        service.delete(nivel);
        return ResponseEntity.noContent().build();
    }
}
