package main;

public class Response {

    private String message;
    private boolean result;

    public Response(String message, boolean result){
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public boolean getResult() {
        return result;
    }
}
