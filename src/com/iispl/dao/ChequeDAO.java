package com.iispl.dao;

import java.util.List;

import com.iispl.model.Cheque;

public interface ChequeDAO {
     List<Cheque> getAllCheques() throws Exception;
     
}
