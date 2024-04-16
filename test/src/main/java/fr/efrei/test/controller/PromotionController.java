package fr.efrei.test.controller;

import fr.efrei.test.model.Promotion;
import fr.efrei.test.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

	private final PromotionService service;

	@Autowired
	public PromotionController(PromotionService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Promotion>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Promotion> save(@RequestBody Promotion promotion) {
		return new ResponseEntity<>(service.save(promotion), HttpStatus.CREATED);
	}


	// promotion 537a8fa0-5f85-4b8c-a214-5470a52b6b6a
	// student 07f1569f-a868-4137-9778-16af17c6499f
	// /promotions/promotionId/students/studentId
	@PatchMapping("/{id}/students/{studentId}")
	public ResponseEntity<Promotion> ajoutEtudiant(@PathVariable String id,
	                                               @PathVariable String studentId) {
		return new ResponseEntity<>(service.ajoutEtudiant(id, studentId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
