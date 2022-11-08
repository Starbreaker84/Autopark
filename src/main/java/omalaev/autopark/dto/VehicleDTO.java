package omalaev.autopark.dto;

public class VehicleDTO {
    private int id;
    private int year;
    private int mileage;
    private int price;
    private int brandId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int id) {
        this.brandId = id;
    }

    public VehicleDTO() {

    }
}
