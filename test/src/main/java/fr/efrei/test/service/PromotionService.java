package fr.efrei.test.service;

import fr.efrei.test.model.Promotion;
import fr.efrei.test.model.Student;
import fr.efrei.test.repository.PromotionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PromotionService {

	private final PromotionRepository repository;
	private final StudentService studentService;

	@Autowired
	public PromotionService(PromotionRepository repository, StudentService studentService) {
		this.repository = repository;
		this.studentService = studentService;
	}

	public List<Promotion> findAll() {
		return repository.findAll();
	}

	public Promotion save(Promotion promotion) {
		return repository.save(promotion);
	}

	@Transactional
	public Promotion ajoutEtudiant(String promotionId, String studentId) {
		Promotion promotion = repository.findById(promotionId).orElse(null);
		Student student = studentService.findStudentById(studentId);
		promotion.getStudents().add(student);
		repository.save(promotion);
		return promotion;
	}

	public void delete(String id) {
		repository.deleteById(id);
	}
}
