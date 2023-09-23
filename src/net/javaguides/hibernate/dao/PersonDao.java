/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.entity.Person;
import net.javaguides.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sam
 */
public class PersonDao {
    /**
     * Method Insert new Person
     * @param person 
     */
    public void insertPerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }
    /**
     * @Method select person by id
     * @param id
     * @return person
     */
    public Person selectPersonById(Long id){
        Person person;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            person = (Person) session.get(Person.class, id);
            session.close();
        }
        return person;
    }
    /**
     * @Method select all persons
     * @return personList
     */
    public List<Person> selectAllPersons(){
        List<Person> personList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            personList = session.createQuery("from Person").list();
        }
        return personList;
    }
    /**
     * Method Update person
     * @param person 
     */
    public void updatePerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    public void saveOrUpdatePerson(Person person){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            comeca a transacao
            transaction = session.beginTransaction();
//            inserir uma pessoa
            session.saveOrUpdate(person);
            Person person2 = session.get(Person.class, 1);
            person2.setName("Samuca");
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    
    /**
     * Method Delete Person
     * @param person 
     */
    public void deletePerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}
