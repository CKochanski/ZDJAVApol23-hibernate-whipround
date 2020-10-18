package pl.sda.dao;


import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Donation;

import java.util.List;

public class DonationDao extends AbstractDao<Donation> {
    public DonationDao() {
        super(Donation.class);
    }

    public List<Donation> findByWhiproundId (int id){
        Session session = SessionProvider.getSession();
        List<Donation> list = session.createQuery("from Donation where whipround.id =:id", Donation.class)
                .setParameter("id", id)
                .list();
        session.close();
        return list;
    }
}
