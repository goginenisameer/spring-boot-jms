package jms.ibmsample.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jms.ibmsample.documents.OrderTransaction;

@Component
public class OrderTransactionReceiver {


  private int count = 1;

  @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
  public void receiveMessage(OrderTransaction transaction) {
    System.out.println("<" + count + "> Received <" + transaction + ">");
    count++;
  }
}
