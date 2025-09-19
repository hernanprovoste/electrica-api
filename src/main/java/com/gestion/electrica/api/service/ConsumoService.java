package com.gestion.electrica.api.service;

import java.util.List;

import com.gestion.electrica.api.model.Consumo;

public interface ConsumoService {
    Consumo registrarConsumo(Consumo consumo);

    List<Consumo> obtenerConsumos();

    Consumo obtenerConsumoPorId(Long id);
}
