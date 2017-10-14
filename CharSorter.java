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
        char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";

        sortArray(characters);
        determineFrequency(frequency, characters);

        for(int x = characters.length-1; x >= 0; x--)
            list += (characters[x] + " freq: " + frequency[x] + "-");

        return removeRepeats(list);
    }

    private static String frequencySort(String a)
    {
        char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";

        sortArray(characters);
        determineFrequency(frequency, characters);

        for(int x = characters.length-1; x >= 0; x--)
            list += (characters[x] + " freq: " + frequency[x] + "-");
        
        int chartoNum = 0;
        int temp;
        String list = "";
        String[] statements = a.split(" ");


        //for(int i = 1; i < statements.length; i++)
       // {
      //      System.out.println((toNumber(statements[i].charAt(7))));
               //if(Integer.parseInt(statements[i].substring(8,9)) < Integer.parseInt(statements[i-1].substring(8,9)))
                //{
                  //  temp = statements[i - 1].indexOf(8,9);
                //}
         //}


        for(int y = 0; y < statements.length; y++)
            list += (statements[y] + "\n");

        return Integer.toString(toNumber(statements[3].charAt(7)));

       /* char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";
        int temp;

        //sortArray(characters);
        determineFrequency(frequency, characters);

        for(int x = 1; x < frequency.length; x++)  //Sorts the character array by number value
        {
            for(int y = x; y > 0; y--)
            {
                if(frequency[y] > frequency[y-1])
                {
                    temp = frequency[y];
                    frequency[y] = frequency[y-1];
                    frequency[y-1] = temp;
                }
            }
        }

        for(int x = 1; x < characters.length; x++)
        {
            for(int x = )
        }

        for(int x = characters.length-1; x >= 0; x--)
            list += (characters[x] + " freq: " + frequency[x] + "-");

        return removeRepeats(list); */
    }

    private static String charTypes(String a)
    {
        return "";
    }

    private static String removeRepeats(String a)
    {
        String freqSplit[] = a.split("-");
        String last = "";

        for (int i = 0; i < freqSplit.length; i++)
        {
            for (int j = i + 1; j < freqSplit.length; j++)
            {
                if ((freqSplit[i].equals(freqSplit[j])) && (i != j))
                {
                    freqSplit[i] = "";
                }
            }
        }
        for(int i = 0; i < freqSplit.length; i++)
        {
            if (!freqSplit[i].equals(""))
            {
                last += (freqSplit[i] + "\n ");
            }

        }
        return last;
    }

    private static void sortArray(char[] a)
    {
        char temp;
        for(int x = 1; x < a.length; x++)  //Sorts the character array by ascii value
        {
            for(int y = x; y > 0; y--)
            {
                if(a[y] > a[y-1])
                {
                    temp = a[y];
                    a[y] = a[y-1];
                    a[y-1] = temp;
                }
            }
        }
    }


    private static void determineFrequency(int[] a, char[] b)
    {
        for(int j = b.length-1; j >= 0; j--)
        {
            for(int i = b.length-1; i >= 0; i--)
            {
                if(b[j] == b[i])
                {
                    a[j]++;
                }
            }
        }
    }


    private static int toNumber(char a)
    {
        int number = 0;

        if (a < 58) {
            number = (int) a - (int) '0';
        }
        return number;
    }
}