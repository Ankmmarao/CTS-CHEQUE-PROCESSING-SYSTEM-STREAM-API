package com.iispl.main;

import java.util.List;
import java.util.Map;
import java.util.DoubleSummaryStatistics;

import com.iispl.dao.ChequeDAO;
import com.iispl.dao.ChequeDAOImpl;
import com.iispl.model.Cheque;
import com.iispl.service.ChequeServices;
import com.iispl.service.ChequeServicesImpl;

public class CTMStreamProcesingApplications {

    public static void start() {

        ChequeDAO chedao = new ChequeDAOImpl();
        List<Cheque> cheques = chedao.getAllCheques();

        ChequeServices service = new ChequeServicesImpl();

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("       ADVANCED CTS STREAM REPORTS");
            System.out.println("==============================================");
            System.out.println("1.  Unique Branch/MICR Values");
            System.out.println("2.  Top 5 Processing Queue");
            System.out.println("3.  Paginated Cheques");
            System.out.println("4.  Record Count");
            System.out.println("5.  Highest/Lowest Cheque");
            System.out.println("6.  Average Cheque Amount");
            System.out.println("7.  Cheque Lookup Map");
            System.out.println("8.  CTS Reference String");
            System.out.println("9.  Count Per Branch");
            System.out.println("10. Total/Average Per Branch");
            System.out.println("11. Branch Statistics");
            System.out.println("12. Branch -> Cheque Numbers");
            System.out.println("13. Finalized Collection");
            System.out.println("14. Pipeline Diagnostics");
            System.out.println("15. Multi-Level Comparator");
            System.out.println("16. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            System.out.println();

            switch (choice) {

            case 1:

                System.out.println("===== UNIQUE CTS VALUES =====");

                System.out.println("Branches : "
                        + service.getUniqueBranchCodes());

                List<String> micrCodes =
                        service.getUniqueMicrCodes();

                System.out.println("MICR Count : "
                        + micrCodes.size());

                System.out.println("MICR Codes : "
                        + micrCodes);

                break;


            case 2:

                System.out.println("===== TOP 5 CTS PROCESSING QUEUE =====");

                List<Cheque> topFive =
                        service.getTopFiveProcessingRecords();

                int rank = 1;

                for (Cheque cheque : topFive) {

                    System.out.printf(
                            "%d. %s | %s | %.2f%n",
                            rank++,
                            cheque.getChequeNumber(),
                            cheque.getBranchCode(),
                            cheque.getAmount().doubleValue()
                    );
                }

                break;


            case 3:

                System.out.print("Enter Page Number : ");
                int pageNumber = sc.nextInt();

                System.out.print("Enter Page Size : ");
                int pageSize = sc.nextInt();

                System.out.println();

                System.out.println("Page Number : "
                        + pageNumber);

                System.out.println("Page Size : "
                        + pageSize);

                System.out.println(
                        "===== CHEQUE PAGE "
                        + pageNumber
                        + " ====="
                );

                service.getChequePage(pageNumber, pageSize)
                        .forEach(c ->
                                System.out.println(
                                        c.getChequeNumber()
                                )
                        );

                break;


            case 4:

                System.out.println("===== CTS RECORD COUNT =====");

                System.out.println(
                        "Total Cheque Records : "
                        + service.getTotalChequeRecordCount()
                );

                break;


            case 5:

                System.out.println("===== AMOUNT EXTREMES =====");

                System.out.print("Highest : ");

                service.getHighestValueCheque()
                        .ifPresentOrElse(
                                c -> System.out.printf(
                                        "%s | %.2f%n",
                                        c.getChequeNumber(),
                                        c.getAmount().doubleValue()
                                ),
                                () -> System.out.println(
                                        "No cheque records found"
                                )
                        );

                System.out.print("Lowest : ");

                service.getLowestValueCheque()
                        .ifPresentOrElse(
                                c -> System.out.printf(
                                        "%s | %.2f%n",
                                        c.getChequeNumber(),
                                        c.getAmount().doubleValue()
                                ),
                                () -> System.out.println(
                                        "No cheque records found"
                                )
                        );

                break;


            case 6:

                System.out.println(
                        "===== AVERAGE CHEQUE AMOUNT ====="
                );

                service.getAverageChequeAmount()
                        .ifPresentOrElse(
                                avg -> System.out.printf(
                                        "Average Amount : %.2f%n",
                                        avg
                                ),
                                () -> System.out.println(
                                        "No cheque records found"
                                )
                        );

                break;


            case 7:

                System.out.println("===== CHEQUE LOOKUP =====");

                Map<String, Cheque> lookup =
                        service.getChequeLookup();

                lookup.forEach((key, value) -> {

                    System.out.println("Key      : "
                            + key);

                    System.out.println("Customer : "
                            + value.getCustomerName());

                    System.out.printf(
                            "Amount   : %.2f%n",
                            value.getAmount().doubleValue()
                    );

                    System.out.println("Branch   : "
                            + value.getBranchCode());

                    System.out.println("--------------------------");
                });

                break;


            case 8:

                System.out.println(
                        "===== APPROVED CTS REFERENCES ====="
                );

                System.out.println(
                        service.getApprovedCtsReferences()
                );

                break;


            case 9:

                System.out.println(
                        "===== CHEQUE COUNT BY BRANCH ====="
                );

                service.getChequeCountByBranch()
                        .forEach((branch, count) ->
                                System.out.println(
                                        branch + " -> " + count
                                )
                        );

                break;


            case 10:

                System.out.println(
                        "===== BRANCH AMOUNT SUMMARY ====="
                );

                service.getBranchAmountSummary()
                        .forEach((branch, summary) -> {

                            System.out.printf(
                                    "%s | Total: %.2f | Average: %.2f%n",
                                    branch,
                                    summary.get("Total"),
                                    summary.get("Average")
                            );

                        });

                break;


            case 11:

                System.out.println(
                        "===== BRANCH STATISTICS ====="
                );

                service.getBranchStatistics()
                        .forEach((branch, stats) -> {

                            System.out.printf(
                                    "%s -> Count=%d, Sum=%.2f, "
                                    + "Avg=%.2f, Min=%.2f, Max=%.2f%n",
                                    branch,
                                    stats.getCount(),
                                    stats.getSum(),
                                    stats.getAverage(),
                                    stats.getMin(),
                                    stats.getMax()
                            );

                        });

                break;


            case 12:

                System.out.println(
                        "===== BRANCH -> CHEQUE NUMBERS ====="
                );

                service.getBranchChequeNumbers()
                        .forEach((branch, numbers) ->
                                System.out.println(
                                        branch + " -> " + numbers
                                )
                        );

                break;


            case 13:

                System.out.println(
                        "===== FINALIZED CTS RESULT ====="
                );

                List<Cheque> finalized =
                        service.getFinalizedCtsResult();

                System.out.println(
                        "Records Collected : "
                        + finalized.size()
                );

                try {

                    finalized.add(null);

                } catch (UnsupportedOperationException e) {

                    System.out.println(
                            "Modification Test : "
                            + e.getClass().getSimpleName()
                    );

                }

                System.out.println(
                        "Result : Collection remains unchanged"
                );

                break;


            case 14:

                System.out.println(
                        "===== STREAM TRACE ====="
                );

                service.traceChequeStream()
                        .forEach(c ->
                                System.out.println(
                                        "Final result : "
                                        + c.getChequeNumber()
                                )
                        );

                System.out.println(
                        "Final result produced successfully."
                );

                break;


            case 15:

                System.out.println(
                        "===== MULTI-LEVEL ORDER ====="
                );

                service.getMultiLevelComparator()
                        .forEach(c ->
                                System.out.printf(
                                        "%s | %s | %.2f%n",
                                        c.getBranchCode(),
                                        c.getChequeNumber(),
                                        c.getAmount().doubleValue()
                                )
                        );

                break;


            case 16:

                System.out.println();
                System.out.println("==============================================");
                System.out.println("                    EXIT");
                System.out.println("==============================================");
                System.out.println("Thank you!");

                break;


            default:

                System.out.println(
                        "Invalid choice! Please enter 1 to 16."
                );
            }

            if (choice != 16) {

                System.out.println();
                System.out.println(
                        "Press Enter to continue..."
                );

                sc.nextLine();
                sc.nextLine();
            }

        } while (choice != 16);

        sc.close();
    }
}