package cs544.exercise16_2;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Component
@NoArgsConstructor
@Getter
@Setter
public class Student {

	@Id
	private long studentid;
	private String firstname;
	private String lastname;

	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Course> courselist = new ArrayList<Course>();

	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
