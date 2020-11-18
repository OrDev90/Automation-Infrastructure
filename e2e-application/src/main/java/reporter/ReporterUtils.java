package reporter;

import java.time.LocalDate;
import java.util.UUID;

public class ReporterUtils {

    protected static String generateReportName() {
        return "Report_" + LocalDate.now() + "_" + UUID.randomUUID().toString();
    }
}
