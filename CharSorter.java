import java.util.*;

public class CharSorter {
    public static void main(String[] args)
    {

        boolean running = true;
        System.out.println("Welcome to Character Sorting Program\nPlease input a string to be sorted");
        Scanner input = new Scanner(System.in);
        String userLine = input.nextLine();
        System.out.print("\n");

        while(running)
        {

            System.out.println("Please select the option you would like to see\n\n" +    // This is the menu
                               "1. Display character frequencies alphabetically\n" +
                               "2. Display sorted frequencies\n" +
                               "3. Show types of character frequencies\n" +
                               "4. Exit ");

            //changed this
            Scanner newInput = new Scanner(System.in);
            int choice = -1;    // Set choice equal to a redundant value not being used
            try
            {
                choice = newInput.nextInt();
            }
            catch (InputMismatchException wrong){/*see default of switch below*/}

            System.out.print("\n");
            switch (choice) {
                case 1:
                    alphabeticalSort(userLine);
                    break;
                case 2:
                    frequencySort(userLine);
                    break;
                case 3:
                    charTypes(userLine);
                    break;
                case 4:
                    running = false;
                    break;
                default:    // default will be the invalid input
                    System.out.println("Error, bad input, please enter a number 1-4\n");
            }
        }
    }

    public static String alphabeticalSort(String a)
    {
        String[] characters = new String[a.length()];
        char[] b = a.toCharArray();

        return "";
    }

    public static String frequencySort(String a)
    {
        return "";
    }

    public static String charTypes(String a)
    {
        return "";
    }
}
