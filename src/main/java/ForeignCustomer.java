public class ForeignCustomer implements Customer {

    // required
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String id;

    // optional
    private final String gender;
    private final String nationality;
    private final String age;

    private String startingTime;
    private String endingTime;
    private String startPoint;
    private String endPoint;
    private  String date;

    TimeCalculator timeCal = new TimeCalculator();

    private ForeignCustomer(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.nationality = builder.nationality;
        this.age = builder.age;
        this.id = builder.id;
    }

    @Override
    public double calculateDistance(){
        return timeCal.timeCount(this.startingTime, this.endingTime)*60;
    }

    @Override
    public double calculateFare(){
        double timeResult = timeCal.timeCount(this.startingTime, this.endingTime);
        double distance = timeResult*60; //the speed is 60 km. per hr., so the distance is time(hrs)*60 km.
        double price = 0;
        int loop = 0;
        double 	priceRate = 10.5;// 10.5 bath in the first 10 km.
        if(distance < 1) return 55;
        do {
            distance--;
            price += priceRate;
            if(loop == 10) {
                loop = 0;
                priceRate++;
            }
            loop++;
        }while(distance < 0);
        return 55+price;
    }

    @Override
    public String getNationality(){
        return this.nationality;
    }

    @Override
    public void setStartingTimeAndStartPoint(String time, String point, String date) {
        this.startingTime = time;
        this.startPoint = point;
        this.date = date;
    }

    @Override
    public void setEndingTimeAndEndPoint(String time, String point) {
        this.endingTime = time;
        this.endPoint = point;
    }

    @Override
    public String toString() {
        return String.format("User: %s %s %s\nId: %s\nAge: %s\nGender: %s\nNationality: %s\n------------------------\n" +
                        "Date: %s\nStart: %s (%s)\nTerminal: %s (%s)\n",
                this.firstName, this.middleName, this.lastName, this.id, this.age, this.gender, this.nationality, this.date,
                this.startPoint, this.startingTime, this.endPoint, this.endingTime);
    }

    public static class Builder {
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private String gender;
        private String nationality;
        private String age;
        private String id;

        public Builder(String firstName, String middleName, String lastName, String id) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.id = id;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        //Return the finally consrcuted User object
        public Customer build() {
            Customer customer = new ForeignCustomer(this);
            return customer;
        }
    }
}
