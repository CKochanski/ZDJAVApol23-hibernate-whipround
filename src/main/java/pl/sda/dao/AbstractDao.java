package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.database.SessionProvider;

public abstract class AbstractDao<T> {




    public void add(T record){
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();
         }



}
