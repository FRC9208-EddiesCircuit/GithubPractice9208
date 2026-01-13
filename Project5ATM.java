import java.util.Scanner;

class User
{
    String username = "Jürgen";
    int pin = 1234;
    int balance = 0;

    public User(String u, int p, int b)
    {
        username = u;
        pin = p;
        balance = b;
    }
}

public class Project5ATM
{
    static Scanner scanner = new Scanner(System.in);

    //Declare users --> (name, pin, balance)
    static User user1 = new User("Jürgen", 1234, 10);
    static User user2 = new User("Gerald", 1111, 20);
    static User user3 = new User("Person Mann", 1337, 10000);
    static User user4 = new User("Seventeen", 17, 17);

    //The current logged-in user
    static User user = null;

    //Array containing all of the user objects
    static User[] users = {user1, user2, user3, user4};

    //Number of times an incorrect pin can be entered
    static int pinTries = 3;

    public static void main(String[] args) 
    {
        initialize();
    }

    //Initializes the program
    public static void initialize()
    {
        if (pinTries <= 0)
        {
            System.out.println("Tried too many times. Get outta here!");
        }
        else
        {

            String name = "";
            int pin = 0;

            System.out.println("Welcome to ATM. Please enter username and pin.");
            System.out.println("Username: ");

            //Check if the name the user has entered exists within the users array
            name = scanner.nextLine();
            for (int i = 0; i < users.length; i++)
            {
                //Valid username
                if (name.equalsIgnoreCase(users[i].username))
                {
                    System.out.println("Pin: ");
                    pin = Integer.parseInt(scanner.nextLine());

                    //Valid pin
                    if (pin == users[i].pin)
                    {
                        user = users[i];
                        System.out.println("Welcome, " + user.username + ".");
                        home();
                        break;
                    }
                    //Invalid pin
                    else
                    {
                        pinTries--;
                        System.out.println("Incorrect pin. Tries remaining: " + Integer.toString(pinTries));
                        initialize();
                        break;
                    }
                }
                //Invalid username
                else if (i == users.length - 1)
                {
                    System.out.println("Incorrect username. Please try again.");
                    initialize();
                }
            }
        }
    }

    //Draws the home menu of the ATM
    static void home()
    {
        pinTries = 3;

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("5. End");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice)
        {
            case 1:
                checkBalance();
            break;

            case 2:
                deposit();
            break;

            case 3:
                withdraw(2);
            break;

            case 4:
                initialize();
            break;

            case 5:
                System.out.println("Goodbye");
            break;

            default:
                home();
            break;
        }
    }

    //Check the user's balance
    static void checkBalance()
    {
        int choice = 0;

        System.out.println("-----------------------");
        System.out.println("Balance: " + user.balance);
        System.out.println("1. Return");
        System.out.println("2. Quit");
        System.out.println("-----------------------");

        choice = Integer.parseInt(scanner.nextLine());
        switch (choice)
        {
            case 1:
                home();
            break;

            case 2:
                initialize();
            break;
        }

    }

    static void deposit()
    {
        int amount = 0;
        int choice = 0;

        System.out.println("Deposit?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        choice = Integer.parseInt(scanner.nextLine());

        switch (choice)
        {
            case 1:
                System.out.println("-----------------------");
                System.out.println("Deposit Amount: ");
                amount = Integer.parseInt(scanner.nextLine());
                user.balance += amount;
                System.out.println("New Balance: " + user.balance);
                System.out.println("-----------------------");

                home();
            break;

            case 2:
                home();
            break;
        }
    }

    static void withdraw(int t)
    {
        if (t <= 0)
        {
            System.out.println("The heck, dude? You don't got that much cheddar. Get outta here!");
            initialize();
        }

        int amount = 0;
        int choice = 0;
        int tries = t;

        System.out.println("Withdraw?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        choice = Integer.parseInt(scanner.nextLine());

        switch (choice)
        {
            case 1:
                System.out.println("-----------------------");
                System.out.println("Withdraw Amount: ");

                amount = Integer.parseInt(scanner.nextLine());
                if (amount <= user.balance)
                    user.balance -= amount;
                else
                {
                    tries--;
                    System.out.println("Invalid amount. Remaining Tries: " + tries);
                    withdraw(tries);
                    return;
                }

                System.out.println("New Balance: " + user.balance);
                System.out.println("-----------------------");

                choice = 0;
                amount = 0;
                home();
            break;

            case 2:
                choice = 0;
                amount = 0;
                home();
            break;
        }
    }
}
