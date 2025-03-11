package org.example.metier;

import org.example.dao.IDao;

public class MetierImpl implements IMetier {

    // Default constructor (important for Spring)
    public MetierImpl() {
    }

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

    /**
     *  Pour injecter dans l'attribut dao
     *  un objet d'une classe qui implémente l'interface IDO
     *  après instantiation
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

}