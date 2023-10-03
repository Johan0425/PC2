/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.TentDAO;
import model.Person;
import model.Tent;

/**
 *
 * @author joanp
 */
public class ControllerTent {

    private final TentDAO tentdao;

    public ControllerTent() {
        this.tentdao = new TentDAO();
    }

    public void LendTent(Tent tent, Person person, String key) {
        tentdao.LendTent(tent, person, key);
    }

    public boolean addOccupand(Tent tent, Person person) {
        return tentdao.addOccupand(tent, person);
    }

    public Tent getTent(int fila, int columna) {
        return tentdao.getTent(fila, columna);
    }

    public void vacateTent(Tent tent) {
        tentdao.vacateTent(tent);
    }

}
