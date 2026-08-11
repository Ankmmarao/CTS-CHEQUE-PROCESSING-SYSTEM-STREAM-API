package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iispl.enums.AccountStatus;
import com.iispl.enums.ChequeType;
import com.iispl.enums.MicrStatus;
import com.iispl.enums.ValidationStatus;
import com.iispl.model.Cheque;
import com.iispl.util.DBUtils;

public class ChequeDAOImpl implements ChequeDAO {

	@Override
	public List<Cheque> getAllCheques() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Cheque";
		
		List<Cheque> chequeList=new ArrayList<>();
		
		Connection con=DBUtils.getDataSource().getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Cheque cheque=new Cheque();
				cheque.setChequeId(rs.getInt("chequeId"));
				cheque.setChequeNumber(rs.getString("chequeNumber"));
				cheque.setAccountNumber(rs.getString("accountNumber"));
				cheque.setCustomerName(rs.getString("customerName"));
				cheque.setBranchCode(rs.getString("branchCode"));
				cheque.setMicrCode(rs.getString("micrCode"));
				cheque.setAmount(rs.getBigDecimal("amount"));
				cheque.setAvailableBalance(rs.getBigDecimal("availableBalance"));
				cheque.setChequeDate(rs.getDate("chequeDate").toLocalDate());
				cheque.setAccountStatus(AccountStatus.valueOf(rs.getString("accountStatus")));
				cheque.setChequeType(ChequeType.valueOf(rs.getString("chequeType")));
				cheque.setMicrStatus(MicrStatus.valueOf(rs.getString("micrStatus")));
				cheque.setValidationStatus(ValidationStatus.valueOf(rs.getString("validationStatus")));
				cheque.setBatchId(rs.getInt("batchId"));
				
				chequeList.add(cheque);
				
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
