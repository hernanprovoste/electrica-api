package com.gestion.electrica.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.electrica.api.model.Consumo;
import com.gestion.electrica.api.service.ConsumoService;

// Controller dedicado a consumir y distribuir la api de consumo
@RestController
@RequestMapping("/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public ResponseEntity<Consumo> registrarConsumo(@RequestBody Consumo consumo) {
        Consumo consumoGuardado = consumoService.registrarConsumo(consumo);
        return ResponseEntity.created(URI.create("/consumos/" + consumoGuardado.getId())).body(consumoGuardado);
    }

    @GetMapping
    public ResponseEntity<List<Consumo>> obtenerConsumos() {
        List<Consumo> consumos = consumoService.obtenerConsumos();
        return ResponseEntity.ok(consumos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumo> obtenerConsumoById(@PathVariable Long id) {
        Consumo consumo = consumoService.obtenerConsumoPorId(id);
        return ResponseEntity.ok(consumo);
    }

    @GetMapping("/latest")
    public ResponseEntity<?> obtenerUltimoConsumoCache() {
        final String key = "consumo:latest";
        Consumo ultimoConsumo = (Consumo) redisTemplate.opsForValue().get(key);
        if (ultimoConsumo != null) {
            return ResponseEntity.ok(ultimoConsumo);
        }
        return ResponseEntity.notFound().build();
    }

}
