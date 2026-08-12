package com.iispl.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.iispl.dao.ChequeDAO;
import com.iispl.dao.ChequeDAOImpl;
import com.iispl.enums.ValidationStatus;
import com.iispl.model.Cheque;

public class ChequeServicesImpl implements ChequeServices {
	
	static ChequeDAO chequeDAO=new ChequeDAOImpl();
	static List<Cheque> cheques =chequeDAO.getAllCheques();

	

	@Override
	public List<String> getUniqueBranchCodes() {
		// TODO Auto-generated method stub
		List<String> branches = cheques.stream().map(Cheque::getBranchCode).distinct().collect(Collectors.toList());
		return branches;
	}

	@Override
	public List<String> getUniqueMicrCodes() {
		// TODO Auto-generated method stub
	
		return cheques.stream().map(Cheque::getMicrCode).distinct().collect(Collectors.toList());
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

	
//	Using the approved-cheque result from the existing application, create one comma-separated chequenumber String
	@Override
	public String getApprovedCtsReferences() {
		 return cheques.stream()
				 		.filter(c->c.getValidationStatus()==ValidationStatus.APPROVED)
				 		.map(Cheque::getChequeNumber)
				 		.collect(Collectors.joining(","));
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

//	Add diagnostic observation to one existing Stream pipeline. Do not use peek() to perform essential
//	business updates.
	@Override
	public List<Cheque> traceChequeStream() {
		List<Cheque> tracedcheques=cheques.stream()
											.peek(c-> System.out.println("Trace -> "+c.getChequeNumber()+" entered pipeline"))
											.collect(Collectors.toList());
		return tracedcheques;
	}

//	Create a reusable Comparator: branch code first, then amount descending, then cheque number.
	@Override
	public List<Cheque> getMultiLevelComparator() {
		
		Comparator<Cheque> chequeComparator =
		        Comparator.comparing(Cheque::getBranchCode)
		                .thenComparing(Cheque::getAmount, Comparator.reverseOrder())
		                .thenComparing(Cheque::getChequeNumber);
		return cheques.stream()
						.sorted(chequeComparator)
						.collect(Collectors.toList());	
		
	}

	@Override
	public List<Cheque> getAllCheques() {
		// TODO Auto-generated method stub
		return chequeDAO.getAllCheques();
	}

}
