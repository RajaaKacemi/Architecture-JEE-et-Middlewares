package org.example.extenstion;

import org.example.dao.IDao;
import org.springframework.stereotype.Component;

@Component("d2")
public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version Web services");
        double t = 11;
        return t;
    }
}
