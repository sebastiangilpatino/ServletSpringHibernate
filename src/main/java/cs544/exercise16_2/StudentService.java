package cs544.exercise16_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@Service
@NoArgsConstructor
public class StudentService {

	@Autowired
	private StudentDAO studentdao;

	@Transactional
	public Student getStudent(long studentid) {
		Student student = studentdao.load(studentid);
		return student;
	}

	@Transactional
	public void postStudent(Student student) {
		studentdao.postStudent(student);
	}
}
