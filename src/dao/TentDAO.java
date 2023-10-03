/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Person;
import model.Tent;
import singleton.Singleton;

/**
 *
 * @author joanp
 */
public class TentDAO {

    private Tent[][] tent;

    public TentDAO() {
        tent = Singleton.getINSTANCE().getTents();
        initTents();
    }

    private void initTents() {
        if (tent[0][0] == null) {
            for (int i = 0; i < tent.length; i++) {
                for (int j = 0; j < tent[i].length; j++) {
                    tent[i][j] = new Tent();
                }
            }
            Singleton.getINSTANCE().writeTent();
        }
        Singleton.getINSTANCE().readTent();
    }

    public void LendTent(Tent tent, Person person, String key) {
        PersonDAO persondao = new PersonDAO(tent);
        persondao.addPerson(person);
        tent.setPadlock(Tent.CLOSE);
        tent.setKey(key);
        Singleton.getINSTANCE().writeTent();
    }

    public boolean addOccupand(Tent tent, Person person) {
        PersonDAO persondao = new PersonDAO(tent);
        boolean respuesta = persondao.addPerson(person);
        if (respuesta) {
            Singleton.getINSTANCE().writeTent();
            return true;
        }
        return false;
    }

    public Tent getTent(int fila, int columna) {
        return tent[fila][columna];
    }

    public void vacateTent(Tent tent) {
        PersonDAO persondao = new PersonDAO(tent);
        persondao.deletePerson();
        tent.setPadlock(Tent.OPEN);
        Singleton.getINSTANCE().writeTent();
    }

}
