package virionis.nikolas.lambda.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import virionis.nikolas.lambda.model.Test;

@FeignClient(value = "lambda", url="https://suc2fpm2qybgyvjzj4mftodsva0fvhgz.lambda-url.us-east-1.on.aws")
public interface LambdaClient {
    // Lambda Function URL (can get it in the AWS Lambda console)
    // String url = "<LAMBDA FUNCTION URL>";

    @PostMapping
    Test test(@RequestBody Test test);

}
