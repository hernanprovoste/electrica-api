package com.gestion.electrica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.electrica.api.model.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {

}
