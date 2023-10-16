/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate;

import java.util.List;
import net.javaguides.hibernate.dao.PersonDao;
import net.javaguides.hibernate.entity.Person;

/**
 *
 * @author sam
 */
public class App {
    
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
//       System.out.println("ola hibernate");
        Person person = new Person(2L,"Amas","Moz");
        personDao.updatePerson(person);
        
//        Person person2 = personDao.selectPersonById(4L);
//        System.out.println("Person Melinha : "+person2);
        
//        personDao.deletePerson(person);
        
        List<Person> personList = personDao.selectAllPersons();
        personList.forEach(s -> System.out.println("Person "+s.getId()+" : "+s));
    }
}
