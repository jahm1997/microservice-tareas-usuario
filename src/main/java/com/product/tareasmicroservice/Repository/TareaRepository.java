package com.product.tareasmicroservice.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.tareasmicroservice.Entity.TareaEntity;

public interface TareaRepository extends MongoRepository<TareaEntity, String>{

	List<TareaEntity> findByUsuarioId(String usuarioId);
	
}
