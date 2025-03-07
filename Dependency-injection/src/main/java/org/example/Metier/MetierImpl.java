package org.example.Metier;

import org.example.Dao.IDao;

public class MetierImpl implements IMetier {

    // Couplage Faible
    private IDao dao;

    @Override
    public double calcul() {
        double T = dao.getData() * 23;
        return T;
    }

}
