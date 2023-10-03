/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Person;
import model.Tent;
import util.LSE;

/**
 *
 * @author joanp
 */
public final class Singleton {
    
    private static final Singleton INSTANCE = new Singleton();
    
    private final LSE<Person> persons;
    private final Tent[][] tents;

    public Singleton() {
        this.persons = readPerson();
        this.tents = readTent();
    }

    public static Singleton getINSTANCE() {
        return INSTANCE;
    }

    public LSE<Person> getPersons() {
        return persons;
    }

    public Tent[][] getTents() {
        return tents;
    }
    
    public void writeTent() {
        try {
            FileOutputStream archivo = new FileOutputStream("tents.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(tents);
        } catch (IOException ex) {
        }
    }

    public Tent[][] readTent() {
        try {
            FileInputStream archivo = new FileInputStream("tents.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Tent[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Tent[3][6];
        }
    }

    public void writePerson() {
        try {
            FileOutputStream archivo = new FileOutputStream("persons.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(persons);
        } catch (IOException ex) {
        }
    }

    public LSE<Person> readPerson() {
        try {
            FileInputStream archivo = new FileInputStream("persons.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (LSE<Person>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }
    
}
