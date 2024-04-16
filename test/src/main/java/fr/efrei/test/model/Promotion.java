package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "promotion_id")
	private List<Student> students = new ArrayList<>();


	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getUuid() {
		return uuid;
	}
}
