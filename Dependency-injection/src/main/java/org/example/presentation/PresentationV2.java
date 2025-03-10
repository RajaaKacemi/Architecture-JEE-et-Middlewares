package org.example.presentation;

import org.example.dao.IDao;
import org.example.metier.IMetier;

import java.io.File;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));

            String doaClassname = scanner.nextLine();
            Class cDao = Class.forName(doaClassname);
            IDao dao = (IDao) cDao.newInstance();
            System.out.println(dao.getData());


            String metierClassname = scanner.nextLine();
            Class cMetier = Class.forName(metierClassname);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            System.out.println(metier.calcul());

        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }
}
