package virionis.nikolas.lambda.model;

/**
 * Example test class to be our reuqest and response class (although python just receives and sends untyped data, java is not so flexible). IRL you'd probably use DTOs
 */
public class Test {
    private String info;
    private String response;

    public Test(String info) {
        this.info = info;
    }

    public Test(String info, String response) {
        this.info = info;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Test() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
