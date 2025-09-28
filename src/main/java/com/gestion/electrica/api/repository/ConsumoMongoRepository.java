package com.gestion.electrica.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gestion.electrica.api.model.document.ConsumoDocument;

public interface ConsumoMongoRepository extends MongoRepository<ConsumoDocument, String> {

}
