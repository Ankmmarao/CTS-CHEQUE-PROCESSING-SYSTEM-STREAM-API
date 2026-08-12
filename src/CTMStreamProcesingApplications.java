import java.util.List;

import com.iispl.dao.ChequeDAO;
import com.iispl.dao.ChequeDAOImpl;
import com.iispl.model.Cheque;
import com.iispl.service.ChequeServices;
import com.iispl.service.ChequeServicesImpl;

public class CTMStreamProcesingApplications {

    public static void start() {
    	ChequeDAO chedao=new ChequeDAOImpl();

        List<Cheque> cheques = chedao.getAllCheques();

        ChequeServices service = new ChequeServicesImpl();

        System.out.println("========================================");
        System.out.println("       CHEQUE STREAM PROCESSING");
        System.out.println("========================================");

        System.out.println("\n1. UNIQUE BRANCH CODES");
        System.out.println(service.getUniqueBranchCodes());

        System.out.println("\n1. UNIQUE MICR CODES");
        System.out.println(service.getUniqueMicrCodes());

        System.out.println("\n2. TOP 5 PROCESSING RECORDS");
        service.getTopFiveProcessingRecords()
                .forEach(System.out::println);

        System.out.println("\n3. PAGINATED CHEQUES");
        service.getChequePage(1, 5)
                .forEach(System.out::println);

        System.out.println("\n4. TOTAL RECORD COUNT");
        System.out.println(service.getTotalChequeRecordCount());

        System.out.println("\n5. HIGHEST VALUE CHEQUE");
        service.getHighestValueCheque()
                .ifPresent(System.out::println);

        System.out.println("\n5. LOWEST VALUE CHEQUE");
        service.getLowestValueCheque()
                .ifPresent(System.out::println);

        System.out.println("\n6. AVERAGE CHEQUE AMOUNT");
        service.getAverageChequeAmount()
                .ifPresent(System.out::println);

        System.out.println("\n7. CHEQUE LOOKUP MAP");
        service.getChequeLookup()
                .forEach((key, value) ->
                        System.out.println(key + " -> " + value));

        System.out.println("\n8. APPROVED CTS REFERENCES");
        System.out.println(service.getApprovedCtsReferences());

        System.out.println("\n9. CHEQUE COUNT BY BRANCH");
        service.getChequeCountByBranch()
                .forEach((branch, count) ->
                        System.out.println(branch + " -> " + count));

        System.out.println("\n10. BRANCH AMOUNT SUMMARY");
        service.getBranchAmountSummary()
                .forEach((branch, summary) ->
                        System.out.println(branch + " -> " + summary));

        System.out.println("\n11. BRANCH STATISTICS");
        service.getBranchStatistics()
                .forEach((branch, stats) ->
                        System.out.println(branch + " -> " + stats));

        System.out.println("\n12. BRANCH -> CHEQUE NUMBERS");
        service.getBranchChequeNumbers()
                .forEach((branch, numbers) ->
                        System.out.println(branch + " -> " + numbers));

        System.out.println("\n13. FINALIZED CTS RESULT");
        service.getFinalizedCtsResult()
                .forEach(System.out::println);

        System.out.println("\n14. PIPELINE DIAGNOSTICS");
        service.traceChequeStream()
                .forEach(System.out::println);

        System.out.println("\n15. MULTI-LEVEL COMPARATOR");
        service.getMultiLevelComparator()
                .forEach(System.out::println);

        System.out.println("\n========================================");
        System.out.println("              EXIT");
        System.out.println("========================================");
    }
}