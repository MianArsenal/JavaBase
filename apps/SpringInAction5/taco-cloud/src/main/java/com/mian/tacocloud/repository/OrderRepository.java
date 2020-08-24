package com.mian.tacocloud.repository;

import com.mian.tacocloud.domain.Order;

public interface OrderRepository {

    Order save(Order order);

}
