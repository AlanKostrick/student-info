package org.wecancodeit.studentinformation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerWebMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentRepository studentRepo;

	@Mock
	private Student student1;

	@Mock
	private Student student2;

	@Test
	public void shouldReturnOkWhenFindAllStudents() throws Exception {
		when(studentRepo.findAll()).thenReturn(Arrays.asList(student1, student2));
		mockMvc.perform(get("/show-students")).andExpect(status().isOk());
		mockMvc.perform(get("/show-students")).andExpect(view().name("students"));
	}

	@Test
	public void shouldAddAllStudentsToTheModel() throws Exception {
		when(studentRepo.findAll()).thenReturn(Arrays.asList(student1, student2));
		mockMvc.perform(get("/show-students")).andExpect(model().attribute("studentsModel", hasSize(2)));
	}

	@Test
	public void shouldReturnOkWhenFindOneStudent() throws Exception {
		when(studentRepo.findOne(1L)).thenReturn(student1);
		mockMvc.perform(get("/show-student?id=1")).andExpect(status().isOk());
		mockMvc.perform(get("/show-student?id=1")).andExpect(view().name("student"));
	}
	
	@Test
	public void shouldAddStudentToModel() throws Exception {
		when(studentRepo.findOne(1L)).thenReturn(student1);
		mockMvc.perform(get("/show-student?id=1")).
		andExpect(model().attribute("studentModel", is(student1)));
	}

}
