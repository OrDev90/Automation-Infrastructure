package runner;

import org.assertj.core.util.Lists;
import org.testng.TestNG;

import java.util.List;
import java.util.Objects;

public class ScenariosRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(Objects.requireNonNull(ScenariosRunner.class.getClassLoader()
                .getResource("SeleniumSuite.xml"))
                .getPath());
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
