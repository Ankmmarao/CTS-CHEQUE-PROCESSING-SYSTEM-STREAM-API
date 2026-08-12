package com.iispl.main;

import java.util.List;

import com.iispl.model.Cheque;
import com.iispl.service.ChequeServices;
import com.iispl.service.ChequeServicesImpl;

public class CTSStreamAPIMain {
  public static void main(String[] args) {
	  
	  ChequeServices service=new ChequeServicesImpl();
	  List<Cheque> cheques =service.getAllCheques();
	  
	  cheques.forEach(System.out::println);
	 
  }  
  
}
