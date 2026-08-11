package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<Cheque> getAllCheques() {
		// TODO Auto-generated method stub
		String sql = "select * from CTS_CHEQUE";

		List<Cheque> chequeList = new ArrayList<>();

		try {
			Connection con = DBUtils.getDataSource().getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
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

				cheque.setAccountStatus(AccountStatus.valueOf(rs.getString("account_status")));

				cheque.setChequeType(ChequeType.valueOf(rs.getString("cheque_type")));

				cheque.setMicrStatus(MicrStatus.valueOf(rs.getString("micr_status")));

				cheque.setValidationStatus(ValidationStatus.valueOf(rs.getString("validation_status")));

				cheque.setBatchId(rs.getInt("batch_id"));

				chequeList.add(cheque);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return chequeList;
	}

	@Override
	public List<Cheque> getChequesByBatch(int batchId) {

		List<Cheque> cheques = new ArrayList<Cheque>();

		String sql = "SELECT * FROM CTS_CHEQUE WHERE batch_id = ?";

		try (Connection connection = DBUtils.getDataSource().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, batchId);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					cheques.add(new Cheque(rs.getInt("cheque_id"), rs.getString("cheque_number"),
							rs.getString("account_number"), rs.getString("customer_name"), rs.getString("branch_code"),
							rs.getString("micr_code"), rs.getBigDecimal("amount"),
							rs.getBigDecimal("available_balance"), rs.getDate("cheque_date").toLocalDate(),
							AccountStatus.valueOf(rs.getString("account_status")),
							ChequeType.valueOf(rs.getString("cheque_type")),
							MicrStatus.valueOf(rs.getString("micr_status")),
							ValidationStatus.valueOf(rs.getString("validation_status")), rs.getInt("batch_id")));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cheques;
	}

	@Override
	public Cheque getChequeByNumber(String chequeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMicrStatus(String chequeNumber, MicrStatus status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateValidationStatus(String chequeNumber, ValidationStatus status) {
		// TODO Auto-generated method stub

	}

}
