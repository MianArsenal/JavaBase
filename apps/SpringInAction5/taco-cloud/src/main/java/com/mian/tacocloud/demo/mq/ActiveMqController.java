package com.mian.tacocloud.demo.mq;

import com.mian.tacocloud.demo.mq.ActiveMqSenderServiceDemo;
import com.mian.tacocloud.domain.Ingredient;
import com.mian.tacocloud.domain.Order;
import com.mian.tacocloud.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    private final ActiveMqSenderServiceDemo activeMqSenderServiceDemo;
    private final ActiveMqJmsTemplateConsumerServiceDemo consumerServiceDemo;

    public ActiveMqController(ActiveMqSenderServiceDemo activeMqSenderServiceDemo, ActiveMqJmsTemplateConsumerServiceDemo consumerServiceDemo) {
        this.activeMqSenderServiceDemo = activeMqSenderServiceDemo;
        this.consumerServiceDemo = consumerServiceDemo;
    }

    @GetMapping("/consume/{method}")
    public String consume(@PathVariable String method) {
        switch (Integer.parseInt(method)) {
            case 0:
            case 1:
                this.consumerServiceDemo.receiveOrderV0();
                break;
            case 2:
            case 3:
            case 4:
                this.consumerServiceDemo.receiveOrderV1();
                break;
            case 5:
            case 6:
                this.consumerServiceDemo.receiveOrderV2();
                break;
        }
        return "SUCCESS";
    }


    @GetMapping("/send/{method}")
    public String send(@PathVariable String method) {
        switch (Integer.parseInt(method)) {
            case 0:
                this.activeMqSenderServiceDemo.sendOrderV0(getOrder());
                break;
            case 1:
                this.activeMqSenderServiceDemo.sendOrderV1(getOrder());
                break;
            case 2:
                this.activeMqSenderServiceDemo.sendOrderV2(getOrder());
                break;
            case 3:
                this.activeMqSenderServiceDemo.sendOrderV3(getOrder());
                break;
            case 4:
                this.activeMqSenderServiceDemo.sendOrderV4(getOrder());
                break;
            case 5:
                this.activeMqSenderServiceDemo.sendOrderV5(getOrder());
                break;
            case 6:
                this.activeMqSenderServiceDemo.sendOrderV6(getOrder());
                break;
            case 7:
                this.activeMqSenderServiceDemo.sendOrderV7(getOrder());
                break;
            case 8:
                this.activeMqSenderServiceDemo.sendOrderV8(getOrder());
                break;
        }
        return "SUCCESS";
    }

    private Order getOrder() {
        Order order = new Order();
        order.setId(123L);
        order.setOrderName("MiAn's Order");
        order.setCity("ZhuHai");
        order.setPlacedAt(new Date());
        Taco taco0 = new Taco();
        taco0.setId(0L);
        taco0.setName("taco0");
        taco0.setCreatedAt(new Date());
        Ingredient ingredient = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
        taco0.getIngredients().add(ingredient);
        Taco taco1 = new Taco();
        taco1.setId(1L);
        taco1.setName("taco0");
        taco1.setCreatedAt(new Date());
        order.getTacos().add(taco0);
        order.getTacos().add(taco1);
        return order;
    }
}
