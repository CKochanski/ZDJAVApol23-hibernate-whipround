package pl.sda.dao;

import pl.sda.model.Donation;

public class DonationDao extends AbstractDao<Donation> {
    public DonationDao() {
        super(Donation.class);
    }
}
