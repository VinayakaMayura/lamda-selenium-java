package lamda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.BlockJUnit4ClassRunner;
import java.util.Optional;
import static java.util.Optional.ofNullable;

public class MyFirstLamda implements RequestHandler<TestRequest, TestResult> {
    private static TestResult testResult;

    public MyFirstLamda() {
        testResult = new TestResult();
    }

    @Override
    public TestResult handleRequest(TestRequest testRequest, Context context) {
        System.out.print("Inside handleRequest" + testRequest);
        Optional<Result> result = Optional.empty();
        try {
            BlockJUnit4ClassRunner runner = new BlockJUnit4ClassRunner(Class.forName(testRequest.getTestClass()));
            runner.filter(new TestFilter(testRequest.getFrameworkMethod()));
            result = ofNullable(new JUnitCore().run(runner));
        } catch (Exception e) {
            System.out.print(e);
        }
        if (result.isPresent()) {
            testResult.setRunCount(result.get().getRunCount());
            testResult.setFailureCount(result.get().getFailureCount());
            testResult.setRunTime(result.get().getRunTime());
        }
        return testResult;
    }
}
