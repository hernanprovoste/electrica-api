package com.gestion.electrica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.electrica.api.model.document.ConsumoDocument;
import com.gestion.electrica.api.repository.ConsumoMongoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/consumos-mongo")
public class ConsumoMongoController {

    @Autowired
    private ConsumoMongoRepository consumoMongoRepository;

    @PostMapping    
    public ResponseEntity<ConsumoDocument> registrar(@RequestBody ConsumoDocument consumo) {
        return ResponseEntity.ok(consumoMongoRepository.save(consumo));
    }
    
}
