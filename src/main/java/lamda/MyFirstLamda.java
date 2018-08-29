package lamda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class MyFirstLamda implements RequestHandler<S3Event, Result> {
    @Override
    public Result handleRequest(S3Event input, Context context) {
        System.out.println("OS NAME ::::::::"  + System.getProperty("os.name"));
        BlockJUnit4ClassRunner runner = null;
        try {
            runner = new BlockJUnit4ClassRunner(Class.forName("tests.StartTests"));
        } catch (InitializationError initializationError) {
            initializationError.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new JUnitCore().run(runner);
    }
}
