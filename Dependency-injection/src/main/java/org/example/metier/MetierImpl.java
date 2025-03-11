package org.example.metier;

import org.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    // Couplage Faible
    private IDao dao = null;


    /**
     * to inject an object into the dao variable
     * of a class that implements the IDao interface
     */
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }



    @Override
    public double calcul() {
        double T = dao.getData() * 23;
        return T;
    }


}