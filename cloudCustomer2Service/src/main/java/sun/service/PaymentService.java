package sun.service;

import org.apache.ibatis.annotations.Param;
import sun.pojo.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id") long id);

}
