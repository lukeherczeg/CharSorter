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

            try { choice = newInput.nextInt(); }
            catch (InputMismatchException wrong){/*see default of switch below*/}

            System.out.print("\n");
            switch (choice) {
                case 1:
                    System.out.println(alphabeticalSort(userLine));
                    break;
                case 2:
                    System.out.println(frequencySort(userLine));
                    break;
                case 3:
                    System.out.println(charTypes(userLine));
                    break;
                case 4:
                    running = false;
                    break;
                default:    // default will be the invalid input
                    System.out.println("Error, bad input, please enter a number 1-4\n");
            }
        }
    }

    private static String alphabeticalSort(String a)
    {
        char[] b = a.toCharArray();
        String list = "";
        int[] frequency = new int[b.length];
        char temp;

        for(int x = 1; x < b.length; x++)
        {
            for(int y = x; y > 0; y--)
            {
                if(b[y] > b[y-1])
                {
                    temp = b[y];
                    b[y] = b[y-1];
                    b[y-1] = temp;
                }
            }
        }

        for(int j = b.length-1; j >= 0; j--)
        {
            for(int i = b.length-1; i >= 0; i--)
            {
                if(b[j] == b[i])
                {
                    frequency[j]++;
                }
            }
        }
        for(int x = b.length-1; x >= 0; x--)
            list += b[x] + " freq: " + frequency[x] + "-";

        return removeRepeats(list);

    }

    private static String frequencySort(String a)
    {
        return "";
    }

    private static String charTypes(String a)
    {
        return "";
    }

    private static String removeRepeats(String a)
    {
        String setWords[] = a.split("-");
        String last = "";

        for (int i = 0; i < setWords.length; i++)
        {
            for (int j = i + 1; j < setWords.length; j++)
            {
                if ((setWords[i].equals(setWords[j])) && i != j)
                {
                    setWords[i] = "";
                }
            }
        }
        for (int i = 0; i < setWords.length; i++)
        {
            if (setWords[i] != "")
            {
                last += (setWords[i] + "\n");
            }

        }
        return last;
    }
}
