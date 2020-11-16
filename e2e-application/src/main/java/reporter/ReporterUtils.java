package reporter;

import java.util.UUID;

public class ReporterUtils {

    protected static String generateReportName() {
        return "Report_" + UUID.randomUUID().toString();
    }
}
