import org.jason.customer.dao.CustomerDao;
import org.jason.customer.dao.CustomerDaoJdbcImpl;
import org.jason.customer.domain.Customer;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by JTrancender on 2017/5/26.
 */
public class CustomerTest {
    private CustomerDao customerDao = new CustomerDaoJdbcImpl();

    @Test
    public void testCreate() {
        java.util.Date a = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(a.getTime());
        System.out.println(timestamp);
        Customer customer = new Customer("127.0.0.3", 1, String.valueOf(new Timestamp(new Date().getTime())), String.valueOf(new Timestamp(new Date().getTime())));
        System.out.println(customer);
        customerDao.create(customer);
        System.out.println("增加成功");
    }

    @Test
    public void testRead() {
        String ip = "127.0.0.1";
        Customer customer = customerDao.read(ip);
        if (null != customer) {
            System.out.println(customer);
        } else {
            System.out.println("不存在");
        }
    }

    @Test
    public void testUpdate() {
        String ip = "127.0.0.1";
        Customer customer = customerDao.read(ip);
        if (null != customer) {
            customer.setTimes(customer.getTimes() + 1);
            customer.setUpdated(String.valueOf(new Timestamp(new Date().getTime())));
            customerDao.update(customer);
        } else {
            System.out.println("不存在");
        }
    }
}
