package org.example.presentation;

import org.example.extenstion.DaoImplV2;
import org.example.metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /**
         * Injection of dependencies by static instantiation
         */
        DaoImplV2 dao = new DaoImplV2();
        /**
         * Injection via constructor
         */
        MetierImpl metier = new MetierImpl(dao);
        System.out.println(metier.calcul());
    }
}