package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.entity.Student;

public class Application {
    
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student("Samuel", "Cossa", "ar.sam.cossa@uem.ac.mz");
		studentDao.saveStudent(student);
                Student student3 = new Student("Fortunatia", "Machava", "natty.machava@nurse");
//		studentDao.insertStudent();
                studentDao.saveStudent(student3);
		// update student
		Student student1 = new Student("Sam", "Cossa", "ar.sam.cossa@uem.ac.mz");
		studentDao.updateStudent(student1);
		// get students
		List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getFirstName()));
		// get single student
		Student student2 = studentDao.getStudent(1);
		System.out.println(student2.getFirstName());
		// delete student
//		studentDao.deleteStudent(1);
	}
}
