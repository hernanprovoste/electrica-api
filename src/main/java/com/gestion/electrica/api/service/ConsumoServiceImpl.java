package com.gestion.electrica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.electrica.api.model.Consumo;
import com.gestion.electrica.api.repository.ConsumoRepository;

@Service
public class ConsumoServiceImpl implements ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Override
    public Consumo registrarConsumo(Consumo consumo) {
        return consumoRepository.save(consumo);
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
