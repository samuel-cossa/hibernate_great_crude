/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate;

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
        Person person = new Person("Samuel","Mozambican");
        personDao.insertPerson(person);
    }
}
