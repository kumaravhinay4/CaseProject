package com.wipro.payment.service;

import java.text.SimpleDateFormat;

import com.wipro.payment.entity.PaymentCard;
import com.wipro.payment.entity.CardTransaction;

public class PaymentMain {
public static void main(String[] args) {
	try{
	CardTransaction monthsTransaction[] = new CardTransaction[5];

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    monthsTransaction[0]=new CardTransaction("1111222233334444",formatter.parse("01/02/2017"),"household",8000.0,"DB");

    monthsTransaction[1]=new CardTransaction("1111222233334444",formatter.parse("05/02/2017"),"Textile",12000.0,"DB");

    monthsTransaction[2]=new CardTransaction("1111222233334444",formatter.parse("12/02/2017"),"movie",2700.0,"DB");

    monthsTransaction[3]=new CardTransaction("1111222233334444",formatter.parse("16/02/2017"),"paid",19000.0,"CR");

    monthsTransaction[4]=new CardTransaction("1111222233334444",formatter.parse("19/02/2017"),"household",4500.0,"DB");

    PaymentCard paybill = new PaymentCard("1111222233334444","ABC123",formatter.parse("02/03/2017"),monthsTransaction);

    System.out.println("Total to be paid : "+paybill.calculateAmount());

    }catch(Exception e){}
}
}
