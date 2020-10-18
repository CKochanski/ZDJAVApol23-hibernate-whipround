package pl.sda;

import pl.sda.dao.DonationDao;
import pl.sda.dao.WhiproundDao;

public class App {
    public static void main(String[] args) {
        WhiproundDao whiproundDao = new WhiproundDao();
        DonationDao donationDao = new DonationDao();
//        UserDao userDao = new UserDao();
//        Whipround whipround = new Whipround("Test", BigDecimal.valueOf(250));
//       whiproundDao.add(whipround);
//        userDao.add(new User("Anna", "Kowalska"));
//        Whipround whipround1 = new Whipround("Animals", BigDecimal.valueOf(2000));
//        whiproundDao.add(whipround1);
//
//        Whipround whiproundfromdatabase1 = whiproundDao.findById(1);
//        Whipround whiproundfromdatabase2 = whiproundDao.findById(2);
//
//        User userDaoById1 = userDao.findById(1);
//
//        donationDao.add(new Donation(BigDecimal.valueOf(50),userDaoById1,whiproundfromdatabase1));
//        donationDao.add(new Donation(BigDecimal.valueOf(75),userDaoById1,whiproundfromdatabase1));
//        donationDao.add(new Donation(BigDecimal.valueOf(2000),userDaoById1,whiproundfromdatabase2));


//        System.out.println(whiproundDao.getActiveWhiprounds());
//        System.out.println(donationDao.findByWhiproundId(1));
        System.out.println(donationDao.findByUserId(1));

    }
}
