package pl.sda;

import pl.sda.dao.WhiproundDao;
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

        Whipround whipround = new Whipround("Test", BigDecimal.valueOf(250));
        whiproundDao.add(whipround);

    }
}
