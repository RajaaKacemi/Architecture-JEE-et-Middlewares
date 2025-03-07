package org.example.Presentation;

import org.example.Dao.DaoImpl;
import org.example.Metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /**
         * Injection of dependencies by static instantiation
         */
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); // Injection via the setter
        System.out.println(metier.calcul());
    }
}
