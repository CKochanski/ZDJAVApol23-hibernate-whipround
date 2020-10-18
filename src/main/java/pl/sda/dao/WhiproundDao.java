package pl.sda.dao;

import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Whipround;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WhiproundDao extends AbstractDao<Whipround> {


    public WhiproundDao() {
        super(Whipround.class);
    }

    public List<Whipround> getActiveWhiprounds() {
        Session session = SessionProvider.getSession();
        List<Object[]> list = session.createQuery("select whipround.id, whipround.goal, sum(donation.amount) "
            + "from Donation donation join donation.whipround whipround "
            + "group by whipround.id", Object[].class).list();
        List<Whipround> records = list.stream()
            .filter(columns -> {
                BigDecimal goal = new BigDecimal(columns[1].toString());
                BigDecimal sum = new BigDecimal(columns[2].toString());
                int result = goal.compareTo(sum);
                return result > 0;
        })
        .map(columns -> {
            int id = Integer.parseInt(columns[0].toString());
            return findById(id);
        })
        .collect(Collectors.toList());
        session.close();
        return records;
    }
}
