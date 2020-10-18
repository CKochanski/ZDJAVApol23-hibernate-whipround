package pl.sda.dao;

import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Whipround;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WhiproundDao extends AbstractDao<Whipround>  {


    public WhiproundDao() {
        super(Whipround.class);
    }

    public List<Whipround> getActiveDonation() {

        Session session = SessionProvider.getSession();
        List <Whipround> records = (List<Whipround>) session.createQuery("select whipround.id, whipround.goal, sum(donation.amount) " +
                "from Whipround whipround join whipround.donation donation " +
                "group by whipround.id")
                .list()
                .stream().filter(whipround->{
                    Object [] columns = (Object[]) whipround;
                    BigDecimal goal = new BigDecimal(columns[1].toString());
                    BigDecimal sum = new BigDecimal(columns[2].toString());
                    int result = goal.compareTo(sum);
                    return result>0;
                }).map(mapToWhipround()).collect(Collectors.toList());

    };

    private Function <Object, Whipround> mapToWhipround() {
        return whipround->{
            Object [] columns = (Object[]) whipround;
            int id = Integer.parseInt(columns[0].toString());
            return findById(id);
        };
    }
}
