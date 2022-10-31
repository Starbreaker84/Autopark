package omalaev.autopark.utils;

public class VehicleErrorResponse {
    private String message;

    public VehicleErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
