package com.graffiti.shop.kafka;

import com.graffiti.shop.domain.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class ProducerService {
    Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private KafkaTemplate<String, OrderDTO> orderRequestKafkaTemplate;

    public void produce(OrderDTO orderDTO) {
        logger.info("Producing the orderRequest " + orderDTO);
        orderRequestKafkaTemplate.send("orders", orderDTO);
    }

}
