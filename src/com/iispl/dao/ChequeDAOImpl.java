package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.iispl.model.Cheque;
import com.iispl.util.DBUtils;

public class ChequeDAOImpl implements ChequeDAO {

	@Override
	public List<Cheque> getAllCheques() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Cheque";
		
		Connection con=DBUtils.getDataSource().getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
