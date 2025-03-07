package org.example.Presentation;

import org.example.Dao.DaoImpl;
import org.example.Metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /**
         * Injection of dependencies by static instantiation
         */
        DaoImpl dao = new DaoImpl();
        /**
         * Injection via constructor
         */
        MetierImpl metier = new MetierImpl(dao);
        System.out.println(metier.calcul());
    }
}
