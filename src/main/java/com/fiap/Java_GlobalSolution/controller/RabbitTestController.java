package com.fiap.Java_GlobalSolution.controller;

import com.fiap.Java_GlobalSolution.Service.ProducerOne;
import com.fiap.Java_GlobalSolution.Service.ProducerTwo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {
    private final ProducerOne producerOne;
    private final ProducerTwo producerTwo;

    public RabbitTestController(ProducerOne producerOne, ProducerTwo producerTwo) {
        this.producerOne = producerOne;
        this.producerTwo = producerTwo;
    }

    @PostMapping("/one")
    public String sendToOne(@RequestBody String msg) {
        producerOne.sendToQueueOne(msg);
        return "Mensagem enviada para fila ONE!";
    }

    @PostMapping("/two")
    public String sendToTwo(@RequestBody String msg) {
        producerTwo.sendToQueueTwo(msg);
        return "Mensagem enviada para fila TWO!";
    }
}
