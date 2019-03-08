package jms.ibmsample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import jms.ibmsample.documents.OrderTransaction;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {

  @Autowired private JmsTemplate jmsTemplate;

  @PostMapping("/send")
  public void send(@RequestBody OrderTransaction transaction) {
    System.out.println("Sending a transaction.");
    jmsTemplate.convertAndSend(
        "OrderTransactionQueue", transaction);
  }
}
