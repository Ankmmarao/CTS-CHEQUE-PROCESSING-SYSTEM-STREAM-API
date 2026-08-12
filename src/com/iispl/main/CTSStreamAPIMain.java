package com.iispl.main;

import java.util.List;

import com.iispl.model.Cheque;
import com.iispl.service.ChequeServices;
import com.iispl.service.ChequeServicesImpl;

public class CTSStreamAPIMain {
  public static void main(String[] args) {
	  
	  CTMStreamProcesingApplications cpa=new CTMStreamProcesingApplications();
	  cpa.start();
  }  
  
}
