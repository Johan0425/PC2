/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Person;
import model.Tent;
import singleton.Singleton;
import util.LSE;

/**
 *
 * @author joanp
 */
public class PersonDAO {

    private final LSE<Person> listPerson;

    public PersonDAO(Tent tent) {
        listPerson = tent.getListPerson();
    }

    public LSE<Person> getListPerson() {
        return listPerson;
    }

    public boolean addPerson(Person person) {
        if (listPerson.size() < 3) {
            listPerson.addDato(person);
            Singleton.getINSTANCE().writeTent();
            return true;
        }
        return false;
    }

    public void deletePerson() {
        int numClientes = listPerson.size();

        for (int i = 0; i < numClientes; i++) {
            listPerson.remove(0);
        }
        Singleton.getINSTANCE().writeTent();
    }

}
