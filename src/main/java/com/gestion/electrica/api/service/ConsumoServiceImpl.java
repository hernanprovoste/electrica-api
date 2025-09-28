package com.gestion.electrica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gestion.electrica.api.model.Consumo;
import com.gestion.electrica.api.repository.ConsumoRepository;

@Service
public class ConsumoServiceImpl implements ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    // Agregamos redis
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public Consumo registrarConsumo(Consumo consumo) {
        // Guardamos la data persistente en Postgres
        Consumo consumoGuardado = consumoRepository.save(consumo);

        // Actualizamos la cache con el ultimo valor
        final String key = "consumo:latest";
        redisTemplate.opsForValue().set(key, consumo);
        return consumoGuardado;
    }

    @Override
    public List<Consumo> obtenerConsumos() {
        return consumoRepository.findAll();
    }

    @Override
    public Consumo obtenerConsumoPorId(Long id) {
        return consumoRepository.findById(id).orElseThrow(() -> new RuntimeException("Consumo no encontrado con ID: " + id));
    }

}
