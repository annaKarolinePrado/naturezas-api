package br.com.natureza.naturezaapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/naturezas")
public class NaturezaResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body("Teste");
    }

}
