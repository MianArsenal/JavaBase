package com.mian.tacocloud.controller;

import com.mian.tacocloud.domain.Order;
import com.mian.tacocloud.repository.jdbc.OrderRepository;
import com.mian.tacocloud.repository.jpa.JpaOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;
    private JpaOrderRepository jpaOrderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, JpaOrderRepository jpaOrderRepository) {
        this.orderRepository = orderRepository;
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            log.info(errors.toString());
            return "orderForm";
        }
        this.orderRepository.save(order);
//        this.jpaOrderRepository.save(order);
        log.info("order information: " + order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
