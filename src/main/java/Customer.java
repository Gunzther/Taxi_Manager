public interface Customer {

    public double calculateDistance();

    public double calculateFare();

    public String toString();

    public String getNationality();

    public void setStartingTimeAndStartPoint(String time, String point, String date);

    public void setEndingTimeAndEndPoint(String time, String point);
}
