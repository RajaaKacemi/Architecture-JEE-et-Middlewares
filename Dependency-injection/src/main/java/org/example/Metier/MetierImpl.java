package org.example.Metier;

import org.example.Dao.IDao;

public class MetierImpl implements IMetier {

    // Couplage Faible
    private IDao dao = null;

    @Override
    public double calcul() {
        double T = dao.getData() * 23;
        return T;
    }

    /**
     * to inject an object into the dao variable
     * of a class that implements the IDao interface
     */
    public void setDao(IDao dao){
        this.dao = dao;
    }

}
