package com.iispl.main;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import com.iispl.dao.ChequeDAO;
import com.iispl.dao.ChequeDAOImpl;
import com.iispl.model.Cheque;
import com.iispl.service.ChequeServices;
import com.iispl.service.ChequeServicesImpl;

public class CTMStreamProcesingApplications {

    public static void start() {
    	
    	ChequeDAO chequesdao=new ChequeDAOImpl();
    		
      List<Cheque> cheques=chequesdao.getAllCheques();
      
        ChequeServices service = new ChequeServicesImpl();

        System.out.println("========================================");
        System.out.println("       CHEQUE STREAM PROCESSING");
        System.out.println("========================================");

        // 1. UNIQUE BRANCH CODES
        System.out.println("\n1. UNIQUE BRANCH CODES");
        System.out.println(service.getUniqueBranchCodes());

        // 2. UNIQUE MICR CODES
        System.out.println("\n2. UNIQUE MICR CODES");
        System.out.println(service.getUniqueMicrCodes());

        // 3. TOP 5 PROCESSING RECORDS
        System.out.println("\n3. TOP 5 PROCESSING RECORDS");

        List<Cheque> topFive = service.getTopFiveProcessingRecords();

        if (topFive != null && !topFive.isEmpty()) {
            topFive.forEach(System.out::println);
        } else {
            System.out.println("No processing records found.");
        }

        // 4. TOTAL RECORD COUNT
        System.out.println("\n4. TOTAL RECORD COUNT");
        System.out.println(service.getTotalChequeRecordCount());

        // 5. HIGHEST / LOWEST VALUE CHEQUE
        System.out.println("\n5. HIGHEST VALUE CHEQUE");

        Optional<Cheque> highest = service.getHighestValueCheque();

        if (highest != null && highest.isPresent()) {
            System.out.println(highest.get());
        } else {
            System.out.println("No cheque found.");
        }

        System.out.println("\n   LOWEST VALUE CHEQUE");

        Optional<Cheque> lowest = service.getLowestValueCheque();

        if (lowest != null && lowest.isPresent()) {
            System.out.println(lowest.get());
        } else {
            System.out.println("No cheque found.");
        }

        // 6. AVERAGE CHEQUE AMOUNT
        System.out.println("\n6. AVERAGE CHEQUE AMOUNT");

        OptionalDouble average = service.getAverageChequeAmount();

        if (average != null && average.isPresent()) {
            System.out.println(average.getAsDouble());
        } else {
            System.out.println("Average cheque amount not available.");
        }

        // 7. CHEQUE LOOKUP MAP
        System.out.println("\n7. CHEQUE LOOKUP MAP");

        Map<String, Cheque> lookup = service.getChequeLookup();

        if (lookup != null && !lookup.isEmpty()) {

            lookup.forEach((chequeNumber, cheque) ->
                    System.out.println(chequeNumber + " -> " + cheque));

        } else {
            System.out.println("Cheque lookup map not available.");
        }

        // 8. APPROVED CTS REFERENCES
        System.out.println("\n8. APPROVED CTS REFERENCES");

        String ctsReferences = service.getApprovedCtsReferences();

        if (ctsReferences != null && !ctsReferences.isEmpty()) {
            System.out.println(ctsReferences);
        } else {
            System.out.println("No approved CTS references found.");
        }

        // 9. COUNT PER BRANCH
        System.out.println("\n9. CHEQUE COUNT BY BRANCH");

        Map<String, Long> branchCount =
                service.getChequeCountByBranch();

        if (branchCount != null && !branchCount.isEmpty()) {

            branchCount.forEach((branch, count) ->
                    System.out.println(branch + " -> " + count));

        } else {
            System.out.println("Branch count not available.");
        }

        // 10. TOTAL / AVERAGE PER BRANCH
        System.out.println("\n10. BRANCH AMOUNT SUMMARY");

        Map<String, Map<String, Double>> branchSummary =
                service.getBranchAmountSummary();

        if (branchSummary != null && !branchSummary.isEmpty()) {

            branchSummary.forEach((branch, values) -> {

                System.out.println(branch);

                values.forEach((key, value) ->
                        System.out.println(
                                "   " + key + " = " + value));
            });

        } else {
            System.out.println("Branch amount summary not available.");
        }

        // 11. BRANCH STATISTICS
        System.out.println("\n11. BRANCH STATISTICS");

        Map<String, DoubleSummaryStatistics> statistics =
                service.getBranchStatistics();

        if (statistics != null && !statistics.isEmpty()) {

            statistics.forEach((branch, stats) -> {

                System.out.println(
                        branch
                        + " -> Count=" + stats.getCount()
                        + ", Sum=" + stats.getSum()
                        + ", Min=" + stats.getMin()
                        + ", Max=" + stats.getMax()
                        + ", Average=" + stats.getAverage()
                );
            });

        } else {
            System.out.println("Branch statistics not available.");
        }

        // 12. BRANCH -> CHEQUE NUMBERS
        System.out.println("\n12. BRANCH -> CHEQUE NUMBERS");

        Map<String, List<String>> branchChequeNumbers =
                service.getBranchChequeNumbers();

        if (branchChequeNumbers != null
                && !branchChequeNumbers.isEmpty()) {

            branchChequeNumbers.forEach((branch, chequeNumbers) ->
                    System.out.println(
                            branch + " -> " + chequeNumbers));

        } else {
            System.out.println(
                    "Branch cheque numbers not available.");
        }

        // 13. FINALIZED COLLECTION
        System.out.println("\n13. FINALIZED CTS RESULT");

        List<Cheque> finalized =
                service.getFinalizedCtsResult();

        if (finalized != null && !finalized.isEmpty()) {
            finalized.forEach(System.out::println);
        } else {
            System.out.println("No finalized cheques found.");
        }

        // 14. PIPELINE DIAGNOSTICS
        System.out.println("\n14. PIPELINE DIAGNOSTICS");

        List<Cheque> traced =
                service.traceChequeStream();

        if (traced != null && !traced.isEmpty()) {
            traced.forEach(System.out::println);
        } else {
            System.out.println("No cheques available for tracing.");
        }

        // 15. MULTI-LEVEL COMPARATOR
        System.out.println("\n15. MULTI-LEVEL COMPARATOR");

        List<Cheque> sorted =
                service.getMultiLevelComparator();

        if (sorted != null && !sorted.isEmpty()) {
            sorted.forEach(System.out::println);
        } else {
            System.out.println("No cheques available for sorting.");
        }

        // EXIT
        System.out.println("\n========================================");
        System.out.println("                 EXIT");
        System.out.println("========================================");
    }
}