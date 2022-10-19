package br.com.natureza.naturezaapi.resources;

import br.com.natureza.naturezaapi.dto.NivelDTO;
import br.com.natureza.naturezaapi.models.Nivel;
import br.com.natureza.naturezaapi.services.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/niveis")
public class NivelResource {

    @Autowired
    NivelService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body("Teste");
    }

    @Transactional(rollbackOn = Exception.class)
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Nivel> salvar(@RequestBody NivelDTO dto) {
        Nivel nivel = service.toEntity(dto);
        nivel = service.save(nivel);
        return ResponseEntity.ok().body(nivel);
    }

}
