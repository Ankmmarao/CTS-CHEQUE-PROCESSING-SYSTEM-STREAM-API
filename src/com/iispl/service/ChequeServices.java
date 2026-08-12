package com.iispl.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

import com.iispl.model.Cheque;

public interface ChequeServices {
	
	public List<Cheque> getAllCheques();
	List<String> getUniqueBranchCodes();
	List<String> getUniqueMicrCodes();

	List<Cheque> getTopFiveProcessingRecords();

	List<Cheque> getChequePage(int pageNumber, int pageSize);

	long getTotalChequeRecordCount();

	Optional<Cheque> getHighestValueCheque();

	Optional<Cheque> getLowestValueCheque();

	OptionalDouble getAverageChequeAmount();

	Map<String, Cheque> getChequeLookup();

	String getApprovedCtsReferences();

	Map<String, Long> getChequeCountByBranch();

	Map<String, Map<String, Double>> getBranchAmountSummary();
	
	Map<String, DoubleSummaryStatistics> getBranchStatistics();

	Map<String, List<String>> getBranchChequeNumbers();

	List<Cheque> getFinalizedCtsResult();
    
	List<Cheque> traceChequeStream();

	Comparator<Cheque> getMultiLevelComparator();
}
