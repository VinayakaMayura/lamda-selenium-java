package lamda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class MyFirstLamda implements RequestHandler<S3Event,String> {
    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        return "My first Lamda function";
    }
}
