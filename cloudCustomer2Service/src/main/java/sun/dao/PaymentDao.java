package sun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.pojo.Payment;

@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);

    Payment queryById(@Param("id") long id);

}
