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
	public List<Cheque> getAllCheques()  {
		// TODO Auto-generated method stub
		String sql="select * from CTS_CHEQUE";
		
		List<Cheque> chequeList=new ArrayList<>();
		
		
		try {
			Connection con=DBUtils.getDataSource().getConnection();

			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Cheque cheque = new Cheque();

				cheque.setChequeId(rs.getInt("cheque_id"));
				cheque.setChequeNumber(rs.getString("cheque_number"));
				cheque.setAccountNumber(rs.getString("account_number"));
				cheque.setCustomerName(rs.getString("customer_name"));
				cheque.setBranchCode(rs.getString("branch_code"));
				cheque.setMicrCode(rs.getString("micr_code"));
				cheque.setAmount(rs.getBigDecimal("amount"));
				cheque.setAvailableBalance(rs.getBigDecimal("available_balance"));
				cheque.setChequeDate(rs.getDate("cheque_date").toLocalDate());

				cheque.setAccountStatus(
				    AccountStatus.valueOf(rs.getString("account_status"))
				);

				cheque.setChequeType(
				    ChequeType.valueOf(rs.getString("cheque_type"))
				);

				cheque.setMicrStatus(
				    MicrStatus.valueOf(rs.getString("micr_status"))
				);

				cheque.setValidationStatus(
				    ValidationStatus.valueOf(rs.getString("validation_status"))
				);

				cheque.setBatchId(rs.getInt("batch_id"));
				
				chequeList.add(cheque);
				
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return chequeList;
	}

	@Override
	public List<Cheque> getChequesByBatch(int batchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cheque getChequeByNumber(String chequeNumber) {
		// TODO Auto-generated method stub
		

		String sql = " SELECT * FROM CTS_CHEQUE WHERE cheque_number = ?";
	    Cheque cheque = null;

		try {
			Connection connection = DBUtils.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, chequeNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				 cheque = new Cheque();
				
				cheque.setChequeId(rs.getInt("cheque_id"));
				cheque.setChequeNumber(rs.getString("cheque_number"));
				cheque.setAccountNumber(rs.getString("account_number"));
				cheque.setCustomerName(rs.getString("customer_name"));
				cheque.setBranchCode(rs.getString("branch_code"));
				cheque.setMicrCode(rs.getString("micr_code"));
				cheque.setAmount(rs.getBigDecimal("amount"));
				cheque.setAvailableBalance(rs.getBigDecimal("available_balance"));
				cheque.setChequeDate(rs.getDate("cheque_date").toLocalDate());
				cheque.setAccountStatus(
					    AccountStatus.valueOf(rs.getString("account_status")));
				cheque.setChequeType(
						ChequeType.valueOf(rs.getString("cheque_type")));
				cheque.setMicrStatus(
					    MicrStatus.valueOf(rs.getString("micr_status")));
				cheque.setValidationStatus(
					    ValidationStatus.valueOf(rs.getString("validation_status")));
				cheque.setBatchId(rs.getInt("batch_id"));
					
			    
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return cheque;
	}
	

	@Override
	public void updateMicrStatus(String chequeNumber, MicrStatus status) {
		// TODO Auto-generated method stubgit
		
	}

	@Override
	public void updateValidationStatus(String chequeNumber, ValidationStatus status) {
		// TODO Auto-generated method stub
		
	}

}
