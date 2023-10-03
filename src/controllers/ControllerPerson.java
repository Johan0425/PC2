/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.PersonDAO;
import model.Person;
import model.Tent;

/**
 *
 * @author joanp
 */
public class ControllerPerson {

    private final PersonDAO persondao;

    public ControllerPerson(Tent tent) {
        this.persondao = new PersonDAO(tent);
    }

    public boolean addPerson(Person person) {
        return persondao.addPerson(person);
    }

    public void deletePerson() {
        persondao.deletePerson();
    }

}
