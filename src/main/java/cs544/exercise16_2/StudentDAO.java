package cs544.exercise16_2;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Student load(long studentid) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentid);
	}

	@Transactional
	public void postStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);

	}
}
