package com.iispl.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.iispl.dao.ChequeDAO;
import com.iispl.dao.ChequeDAOImpl;
import com.iispl.model.Cheque;

public class ChequeServicesImpl implements ChequeServices {
	
	static ChequeDAO chequeDAO=new ChequeDAOImpl();
	static List<Cheque> cheques =chequeDAO.getAllCheques();

	

	@Override
	public List<String> getUniqueBranchCodes() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUniqueMicrCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getTopFiveProcessingRecords() {
		// TODO Auto-generated method stub
		
		List<Cheque> result=cheques.stream().
				sorted(Comparator.comparing(Cheque::getAmount).reversed()).
				limit(5).toList();
		
		
		
		
		return result;
	}

	@Override
	public List<Cheque> getChequePage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalChequeRecordCount() {
		// TODO Auto-generated method stub
		return 0;
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

	    Map<String, Double> summing = cheques.stream()
	        .collect(Collectors.groupingBy(
	            Cheque::getBranchCode,
	            Collectors.summingDouble(Cheque::getAmount)
	        ));

	    Map<String, Double> average = cheques.stream()
	        .collect(Collectors.groupingBy(
	            Cheque::getBranchCode,
	            Collectors.averagingDouble(Cheque::getAmount)
	        ));

	    Map<String, Map<String, Double>> result = new HashMap<>();

	    summing.forEach((branch, total) -> {
	        Map<String, Double> values = new HashMap<>();

	        values.put("Total", total);
	        values.put("Average", average.get(branch));

	        result.put(branch, values);
	    });

	    return result;
	}

	@Override
	public Map<String, DoubleSummaryStatistics> getBranchStatistics() {
		
		Map<String,DoubleSummaryStatistics> results=cheques.stream()
				.collect(Collectors.groupingBy(Cheque::getBranchCode,
					        Collectors.summarizingDouble(Cheque::getAmount)
					    )
					);
		
		// TODO Auto-generated method stub
		return results;
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
