package org.wecancodeit.studentinformation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class StudentRepositoryTest {

	Student student1 = new Student(1L, "Bryan", "https://github.com/bryancharleslong");
	Student student2 = new Student(2L, "Addie", "https://github.com/addiedavis");

	@Test
	public void shouldFindStudent1() {
		StudentRepository underTest = new StudentRepository(student1);
		Student foundStudent = underTest.findOne(1L);
		assertThat(foundStudent, is(student1));
	}

	@Test
	public void shouldFindStudent2() {
		StudentRepository underTest = new StudentRepository(student2);
		Student foundStudent = underTest.findOne(2L);
		assertThat(foundStudent, is(student2));
	}
	
	@Test
	public void shouldFindAllStudents() {
		StudentRepository underTest = new StudentRepository(student1,student2);
		Collection<Student> foundStudents = underTest.findAll();
		assertThat(foundStudents, containsInAnyOrder(student1,student2));
	}

}
