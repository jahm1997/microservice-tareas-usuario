package com.product.tareasmicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.tareasmicroservice.Entity.TareaEntity;
import com.product.tareasmicroservice.Repository.TareaRepository;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping("/tareas")
public class TareasController {

	@Autowired
	private TareaRepository tareasRepo;
	
	@GetMapping
	public ResponseEntity<List<TareaEntity>> getAllTareas() {
		List<TareaEntity> tareasEntities = tareasRepo.findAll();
		ResponseEntity<List<TareaEntity>> responseEntity = new ResponseEntity<>(tareasEntities, HttpStatus.OK);
		System.out.println(responseEntity);
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<TareaEntity> getTareas(@PathVariable("id") String id) {
		TareaEntity response = tareasRepo.findById(id).orElse(null);
		if (response == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createTareas(@RequestBody TareaEntity tareaEntity) {
		tareasRepo.save(tareaEntity);
	}
	
	@GetMapping("/usuario/{id}")
	public List<TareaEntity> getByUser(@PathVariable("id") String id) {
		return tareasRepo.findByUsuarioId(id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<TareaEntity> updateContactPartially(@PathVariable("id") String id,
			@RequestBody TareaEntity updatedContact) {
		TareaEntity existingContact = tareasRepo.findById(id).orElse(null);
		if (existingContact == null) {
			return ResponseEntity.notFound().build();
		}

		if (updatedContact.getTitle() != null) {
			existingContact.setTitle(updatedContact.getTitle());
		}
		if (updatedContact.getCompleted() != null) {
			existingContact.setCompleted(updatedContact.getCompleted());
		}

		TareaEntity updatedEntity = tareasRepo.save(existingContact);

		return ResponseEntity.ok(updatedEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deletetarea(@PathVariable("id") String id ) {
		tareasRepo.deleteById(id);
	}
}
