package net.javaguides.hibernate.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;
/**
 * 
 * @author sam
 */
public class StudentDao {
    /**
     * 
     * @param student 
     */
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // operation 1
            Object object = session.save(student);
            // operation 2
            session.get(Student.class, (Serializable) object);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    /**
     * @Method insert Student
     */
    public void insertStudent() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            String hql = "INSERT INTO Student (firstName, lastName, email) "
                    + "SELECT firstName, lastName, email FROM Student";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            String hql = "UPDATE Student set firstName = :firstName " + "WHERE id = :studentId";
            Query query = session.createQuery(hql);
            query.setParameter("firstName", student.getFirstName());
            query.setParameter("studentId", 1);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    /**
     * @Method delete Student by id
     * @param id 
     */
    public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                String hql = "DELETE FROM Student " + "WHERE id = :studentId";
                Query query = session.createQuery(hql);
                query.setParameter("studentId", id);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Student getStudent(int id) {

        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            String hql = " FROM Student S WHERE S.id = :studentId";
            Query query = session.createQuery(hql);
            query.setParameter("studentId", id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                student = (Student) results.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return student;
    }

    public List<Student> getStudents() {
        List<Student> studentList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            studentList = session.createQuery("from Student", Student.class).list();
            return studentList;
        }
    }
}
