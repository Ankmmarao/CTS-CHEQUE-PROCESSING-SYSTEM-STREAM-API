package com.iispl.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
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
		return cheques.stream().map(Cheque::getBranchCode).distinct().collect(Collectors.toList());
	}

	@Override
	public List<String> getUniqueMicrCodes() {
		// TODO Auto-generated method stub
	
		return cheques.stream().map(Cheque::getMicrCode).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Cheque> getTopFiveProcessingRecords() {
		// TODO Auto-generated method stub
		
		List<Cheque> result=cheques.stream().sorted(Comparator.
				comparing(Cheque::getAmount).reversed()).limit(5).toList();
		
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
	       return chequeDAO.getAllCheques().stream()
	                .count();
	    }

	
	@Override
	public Optional<Cheque> getHighestValueCheque() {
		// TODO Auto-generated method stub
		return cheques.stream().max(Comparator.comparing(Cheque::getAmount));
	}

	@Override
	public Optional<Cheque> getLowestValueCheque() {
		// TODO Auto-generated method stub
		return cheques.stream().min(Comparator.comparing(Cheque::getAmount));
	}

	@Override
	public OptionalDouble getAverageChequeAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Cheque> getChequeLookup() {
		// TODO Auto-generated method stub
		return cheques.stream().collect(Collectors.toMap(Cheque::getChequeNumber, Function.identity(),(existing,duplicate) -> existing));
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
		return cheques.stream().collect(Collectors.groupingBy(Cheque::getBranchCode,Collectors.counting()));
	}

	@Override
	public Map<String, Map<String, Double>> getBranchAmountSummary() {

	    Map<String, Double> summing = cheques.stream()
	            .collect(Collectors.groupingBy(
	                    Cheque::getBranchCode,
	                    Collectors.summingDouble(cheque -> cheque.getAmount().doubleValue())
	            ));

	    Map<String, Double> average = cheques.stream()
	            .collect(Collectors.groupingBy(
	                    Cheque::getBranchCode,
	                    Collectors.averagingDouble(cheque -> cheque.getAmount().doubleValue())
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
		
		Map<String, DoubleSummaryStatistics> result = cheques.stream()
		        .collect(Collectors.groupingBy(
		                Cheque::getBranchCode,
		                Collectors.summarizingDouble(
		                        cheque -> cheque.getAmount().doubleValue()
		                )
		        ));
		
		// TODO Auto-generated method stub
		return  result;
	}

	@Override
	public Map<String, List<String>> getBranchChequeNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getFinalizedCtsResult() {
		// TODO Auto-generated method stub
	List<Cheque> finalizedResult=cheques.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return finalizedResult;
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
