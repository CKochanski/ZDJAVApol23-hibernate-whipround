package pl.sda;

import pl.sda.dao.DonationDao;
import pl.sda.dao.UserDao;
import pl.sda.dao.WhiproundDao;
import pl.sda.model.User;
import pl.sda.model.Whipround;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WhiproundDao whiproundDao = new WhiproundDao();
        DonationDao donationDao = new DonationDao();
        UserDao userDao = new UserDao();
        Whipround whipround = new Whipround("Test", BigDecimal.valueOf(250));
        whiproundDao.add(whipround);
        userDao.add(new User("Anna", "Kowalska"));
        Whipround whipround1 = new Whipround("Animals", BigDecimal.valueOf(2000));
        whiproundDao.add(whipround1);


    }
}
