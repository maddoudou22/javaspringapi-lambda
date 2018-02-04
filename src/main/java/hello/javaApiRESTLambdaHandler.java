package hello.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

@SuppressWarnings("unused")
public class javaApiRESTLambdaHandler {

    public String myHandler(int input, Context context) {
        LambdaLogger logger = context.getLogger();
        StringBuilder result = new StringBuilder("");
        result.append("Input Parameter " + input + " is ");

        if(isPrime(input)) {
            result.append("a PRIME");
        } else {
            result.append("NOT a PRIME");
        }
        logger.log(result.toString());
        return result.toString();
    }

    public String myTestHandler(String name, Context context) {
        return String.format("New Hello %s.", name);
    }

    private boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

}
