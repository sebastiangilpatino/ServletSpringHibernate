package cs544.exercise16_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;

	private WebApplicationContext springContext;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);

		// test
		Student student = new Student(11335, "Jorge", "GilPatino");
		Course course1 = new Course("EA", "A");
		Course course2 = new Course("WAA", "A");
		student.addCourse(course1);
		student.addCourse(course2);
		studentService.postStudent(student);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");

		long studentid = -1;
		Student student = null;

		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			student = studentService.getStudent(studentid);
		}

		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);

	}

}
