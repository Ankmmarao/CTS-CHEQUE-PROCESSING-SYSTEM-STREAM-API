package com.iispl.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

import com.iispl.dao.ChequeDAO;

import com.iispl.dao.ChequeDAOImpl;
import com.iispl.model.Cheque;

public class ChequeServicesImpl implements ChequeServices {
	
	static ChequeDAO chequeDAO=new ChequeDAOImpl();
	

	@Override
	public Set<String> getUniqueBranchCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getUniqueMicrCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getTopFiveProcessingRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getChequePage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalChequeRecordCount() {
		// TODO Auto-generated method stub
	       return chequeDAO.getAllCheques().stream()
	                .count();
	    }

	
	@Override
	public Optional<Cheque> getHighestValueCheque() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cheque> getLowestValueCheque() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public OptionalDouble getAverageChequeAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Cheque> getChequeLookup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApprovedCtsReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getChequeCountByBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, Double>> getBranchAmountSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, DoubleSummaryStatistics> getBranchStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<String>> getBranchChequeNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getFinalizedCtsResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> traceChequeStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Cheque> getMultiLevelComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getAllCheques() {
		// TODO Auto-generated method stub
		return chequeDAO.getAllCheques();
	}

}
