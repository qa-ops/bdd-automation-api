import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarentine",
        plugin = {"pretty", "html:build/reports/feature.html"},
        features = {"src/test/resources/features"}
)
public class CucumberRunner {
}
