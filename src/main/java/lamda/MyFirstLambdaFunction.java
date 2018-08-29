package lamda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class MyFirstLambdaFunction implements RequestHandler<S3Event, String>  {

    @Override
    public String handleRequest(S3Event input, Context context) {
        return "This is my vodQA demo lambda function.";
    }

}
