/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import util.LSE;

/**
 *
 * @author joanp
 */
public class Tent implements Serializable{

    public final static String CLOSE = "close";
    public final static String OPEN = "open";

    private final LSE<Person> listPerson;

    private String padlock;
    private String key;

    public Tent() {
        this.padlock = OPEN;
        this.listPerson = new LSE<>();
    }

    public String getPadlock() {
        return padlock;
    }

    public void setPadlock(String padlock) {
        this.padlock = padlock;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LSE<Person> getListPerson() {
        return listPerson;
    }

}
