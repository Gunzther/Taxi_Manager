import java.util.*;

public class TaxiDriver {

    // required
    private final String firstName;
    private final String lastName;
    private final String id;

    // optional
    private final String gender;
    private final String nationality;
    private final String age;

    private String user;
    private String password;
    private int carNumber;

    private List<Customer> customerList = new ArrayList<>();

    public TaxiDriver(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.nationality = builder.nationality;
        this.age = builder.age;
        this.id = builder.id;

        this.user = "-";
        this.password = "-";
        this.carNumber = -1;
    }

    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }

    public List<Customer> getCustomerList(){
        return customerList;
    }

    public int getCarNumber(){
        return this.carNumber;
    }

    public void setCarNumber(int num){
        this.carNumber = num;
    }

    public String getUser(){
        return this.user;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUserPassword(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void printAllCustomersDetail(){
        for(Customer c : customerList){
            System.out.println("=======================");
            System.out.println(c.toString());
        }
        System.out.println("=======================");
    }

    @Override
    public String toString() {
        return String.format("User: %s %s\nId: %d\nAge: %d\nGender: %s\nNationality: %s\n",
                this.firstName, this.lastName, this.id, this.age, this.gender, this.nationality);
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private String gender;
        private String nationality;
        private String age;
        private String id;

        public Builder(String firstName, String lastName, String id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = "Thai";
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

        //Return the finally consrcuted User object
        public TaxiDriver build() {
            TaxiDriver td = new TaxiDriver(this);
            return td;
        }
    }
}
