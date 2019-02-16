package org.wecancodeit.studentinformation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	private Map<Long, Student> studentList = new HashMap<>();
	
	public StudentRepository() {
		Student student1 = new Student(1L, "Bryan", "https://github.com/bryancharleslong");
		Student student2 = new Student(2L, "Addie", "https://github.com/addiedavis");
		
		studentList.put(student1.getId(), student1);
		studentList.put(student2.getId(), student2);
	}

	public StudentRepository(Student... students) {
		for (Student student : students) {
			studentList.put(student.getId(), student);
		}
	}

	public Student findOne(long id) {
		return studentList.get(id);
	}

	public Collection<Student> findAll() {
		return studentList.values();
	}

}
