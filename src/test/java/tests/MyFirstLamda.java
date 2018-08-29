//package tests;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.amazonaws.services.lambda.runtime.events.S3Event;
//import org.junit.runners.model.InitializationError;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runners.BlockJUnit4ClassRunner;
//
//import static java.lang.Class.forName;
//
//public class MyFirstLamda implements RequestHandler<S3Event, Result> {
//    @Override
//    public Result handleRequest(S3Event s3Event, Context context) {
//
//        BlockJUnit4ClassRunner runner = null;
//        try {
//            runner = new BlockJUnit4ClassRunner(forName("StartTests"));
//        } catch (InitializationError initializationError) {
//            initializationError.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Result result = new JUnitCore().run(runner);
//
//        return result;
//    }
//
//
//
//}

