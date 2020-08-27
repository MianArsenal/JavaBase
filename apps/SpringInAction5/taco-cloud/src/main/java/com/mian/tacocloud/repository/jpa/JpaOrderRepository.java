package com.mian.tacocloud.repository.jpa;

import com.mian.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface JpaOrderRepository extends CrudRepository<Order, Long> {
}
