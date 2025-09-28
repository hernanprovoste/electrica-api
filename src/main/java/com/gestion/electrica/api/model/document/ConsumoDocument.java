package com.gestion.electrica.api.model.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "consumos")
@Data
public class ConsumoDocument {

    @Id
    private String id;
    private LocalDateTime fecha;
    private double valor;
    private String medidorId;

}
