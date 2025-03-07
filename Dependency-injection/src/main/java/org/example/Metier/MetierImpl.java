package org.example.Metier;

import org.example.Dao.DaoImpl;
import org.example.Dao.IDao;

public class MetierImpl implements IMetier {

    /**
     * to inject an object into the dao variable
     * of a class that implements the IDao interface
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    // Couplage Faible
    private IDao dao = null;

    @Override
    public double calcul() {
        double T = dao.getData() * 23;
        return T;
    }


}
