/**
 * This program is for admin and taxi driver.
 * 1.) You have to register your account, and you can register only 1 time.
 * 2.) You have to login before working.
 * 3.) If you are admin account, you can print all of the work history.
 * 4.) When you already login, you have 3 choices to choose.
 *     - start the work
 *     - logout
 *     - quit
 * 5.) [S]tart work - This program will show "date" and ask you a starting point(such as KU,hospital etc.).
 *                    It'll show you the time that you are at starting point.
 *                    Next, you have to press [S]top when you arrive at the destination.
 *                    It'll show you the time that you are at ending point, distance from starting point to ending point,
 *                    and total price.
 * 6.) I calculate the result of price from distance.(The average of speed of taxi is 60 per hr)
 */
import java.util.*;
import java.time.LocalDateTime;

public class App implements Iterable<TaxiDriver>{

    public boolean check;
    public boolean close;
    public boolean nextStep;
    public boolean logout;
    public TaxiDriver taxiDriver;

    private List<TaxiDriver> taxiDriverList = new ArrayList<>();
    private TaxiDriverCounter counter = new NormalTaxiDriverCounter();

    @Override
    public Iterator<TaxiDriver> iterator() {
        this.counter.setTaxiDriverList(taxiDriverList);
        return this.counter;
    }

    public void setCounter(TaxiDriverCounter counter) {
        this.counter = counter;
    }

    public String scanWord() {
        Scanner myScan = new Scanner(System.in);
        return myScan.nextLine().trim();
    }

    public String date() {
        String dateTime = LocalDateTime.now().toString();
        String date = dateTime.substring(0, 10);
        return date;
    }

    public String time() {
        String dateTime = LocalDateTime.now().toString();
        String time = dateTime.substring(11, 19);
        return time;
    }

    public TaxiDriver loginCheck(String user,String pass) {
        this.setCounter(new NormalTaxiDriverCounter());
        for(TaxiDriver td : taxiDriverList){
            if(user.equals(td.getUser()) && pass.equals(td.getPassword())) return td;
        }
        return null;
    }

    public boolean login() {
        if(taxiDriverList.size() == 0) {
            System.out.println("Empty taxi driver account!!\nPlease sign-up.");
            return false;
        }
        String choose2;
        do {
            System.out.print("Username: ");
            String user = scanWord();
            System.out.print("Password: ");
            String pass = scanWord();

            taxiDriver = loginCheck(user, pass);

            if(taxiDriver != null) {
                Random rand = new Random();
                int carNum = rand.nextInt(100);
                taxiDriver.setCarNumber(carNum);
                System.out.println("\nHello, " + taxiDriver.getFirstName() + "!!! Your car's number is "+ carNum);
                return true;
            }
            else {
                System.out.print("Wrong username or password, please [T]ry again!! or [Q]uit: ");
                choose2 = scanWord();
            }
        }while(choose2.equalsIgnoreCase("T"));
        if(choose2.equalsIgnoreCase("Q")) {
            close = true;
        }
        return false;
    }

    public void saveInformation(TaxiDriver td) {
        this.setCounter(new NormalTaxiDriverCounter());
        for(TaxiDriver t: taxiDriverList){
            if(t.toString().equalsIgnoreCase(td.toString())){
                System.out.println("You are already have an account!!");
                check = false;
                return;
            }
        }
        taxiDriverList.add(td);
    }

    public void saveAccount(String username, TaxiDriver td) {
        this.setCounter(new ReverseTaxiDriverCounter());
        for(TaxiDriver t : taxiDriverList){
            if(username.equals(t.getUser())){
                System.out.println("This username already exist!!");
                check = false;
                return;
            }
        }
        check = true;
        System.out.print("Please enter password: ");
        String password = scanWord();
        td.setUserPassword(username, password);
    }

    public void introAccount(TaxiDriver td) {
        String username;
        System.out.println("\n==== CREATE DRIVER'S ACCOUNT ====");
        do {
            System.out.print("Please enter username: ");
            username = scanWord();
            saveAccount(username, td);
        }while(!check);
    }

    public TaxiDriver introRegist() {
        System.out.println("\n==== THIS IS QUICK REGISTERATION!!! ====");
        System.out.print("Please enter your first name: ");
        String name = scanWord();
        System.out.print("Please enter your last name: ");
        String lastName = scanWord();
        System.out.print("Please enter your id(13 numbers): ");
        String id = scanWord();
        System.out.print("Please enter your age: ");
        String age = scanWord();
        System.out.print("Please enter your gender(F/M): ");
        String gender = scanWord();

        TaxiDriver td = new TaxiDriver.Builder(name, lastName, id)
                .age(age)
                .gender(gender)
                .build();

        return td;
    }

    public void registration() {
        String choose1;
        TaxiDriver td;
        do {
            td = introRegist();
            System.out.println("\n...Please check your information...");
            System.out.print("[C]ontinue [R]egis-again(Edit) or [B]ack to main menu: ");
            choose1 = scanWord();

            if(choose1.equalsIgnoreCase("C")) {
                saveInformation(td);
                if(!check) {
                    System.out.print("\n[B]ack [R]egis-again or [Q]uit: ");
                    choose1 = scanWord();
                }
                else introAccount(td);
            }
        }while(choose1.equalsIgnoreCase("R"));
        if(choose1.equalsIgnoreCase("B")) return;
    }

    public String taxiIntro() {
        System.out.print("[S]tart-work [P]rint all customer detail [L]ogout or [Q]uit: ");
        String choose3 = scanWord();
        if(choose3.equalsIgnoreCase("Q")) {
            System.exit(0);
        }
        else if(choose3.equalsIgnoreCase("L")) {
            logout = true;
            return "L";
        }
        return choose3;
    }

    public Customer createCustomer(String first, String mid, String last, String id, String na){
        Customer customer;
        if(mid == null) customer = new ThaiCustomer.Builder(first, last, id)
                                        .age("-")
                                        .gender("-")
                                        .build();
        else{
            customer = new ForeignCustomer.Builder(first, mid, last, id)
                                        .age("-")
                                        .gender("-")
                                        .nationality(na)
                                        .build();
        }
        return customer;
    }


    public void taxiManagement() {
        String choose5;
        String stop;
        String firstName, middleName = null, lastName, id, na = "US";
        do {
            choose5 = taxiIntro();
            if (choose5.equals("L")) return;
            else if(choose5.equalsIgnoreCase("S")) {

                System.out.print("[T]hai or [F]oreign customer: ");
                String cus = scanWord();
                if(cus.equalsIgnoreCase("T")){
                    System.out.print("Customer first name: ");
                    firstName = scanWord();
                    System.out.print("Customer last name: ");
                    lastName = scanWord();
                    System.out.print("Customer id: ");
                    id = scanWord();
                }
                else{
                    System.out.print("Customer first name: ");
                    firstName = scanWord();
                    System.out.print("Customer middle name: ");
                    middleName = scanWord();
                    System.out.print("Customer last name: ");
                    lastName = scanWord();
                    System.out.print("Customer nationality: ");
                    na = scanWord();
                    System.out.print("Customer id: ");
                    id = scanWord();
                }

                Customer customer = createCustomer(firstName, middleName, lastName, id, na);

                String date = date();
                System.out.println("\n"+ date);


                System.out.print("The starting point: ");
                String startPoint = scanWord();

                String time = time();
                System.out.println("The departure start at "+ time);

                customer.setStartingTimeAndStartPoint(time, startPoint, date);

                System.out.print("\nPress [S]top when you arrive at the destination. >>> ");
                stop = scanWord();

                if(stop.equalsIgnoreCase("S")) {
                    String newTime = time();
                    System.out.println("\nThe departure stop at "+ newTime);

                    System.out.print("The ending point: ");
                    String terminal = scanWord();

                    customer.setEndingTimeAndEndPoint(newTime, terminal);

                    System.out.printf("Distance: %.2f km\n", customer.calculateDistance());
                    System.out.printf("Total price: %.2f baht\n\n", customer.calculateFare());
                }
                taxiDriver.addCustomer(customer);
            }
            else if(choose5.equalsIgnoreCase("P")){
                taxiDriver.printAllCustomersDetail();
            }
        }while(!close);
    }

    public void mainIntro() {
        String choose0 = "";
        do {
            System.out.print("\nPlease [L]ogin [S]ign-up or [Q]uit: ");
            choose0 = scanWord();
            if(choose0.equalsIgnoreCase("L") && login()) {
                close = false;
                nextStep = true;
                return;
            }
            else if (choose0.equalsIgnoreCase("S")) {
                registration();
                check = true;
            }
            else if (choose0.equalsIgnoreCase("Q")) {
                System.exit(0);
            }
        }while(!choose0.equalsIgnoreCase("Q") || !close);
    }

    public void run() {
        check = true;
        close = false;
        nextStep = false;
        logout = false;
        System.out.println("+++++ Welcome to Jenny-Taxi-Management +++++");
        do {
            mainIntro();
            if(close) break;
            if(nextStep) taxiManagement();
            if(logout) continue;
        }while(true);
        System.out.println("Thank you!!");
    }
}
