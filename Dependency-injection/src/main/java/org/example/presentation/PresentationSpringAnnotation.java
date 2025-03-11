package org.example.presentation;

import org.example.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("Resultats : " + metier.calcul());
    }
}
