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

            switch (choice) {
                case 1:
                    System.out.println(alphabeticalSort(userLine));
                    break;
                case 2:
                    System.out.println("The sorted by frequency characters are:\n" + frequencySort(userLine));
                    break;
                case 3:
                    System.out.println(charTypes(userLine));
                    break;
                case 4:
                    running = false;
                    System.out.println("\nCharacter Sorter Exited Successfully");
                    break;
                default:    // default will be the invalid input
                    System.out.println("Error, bad input, please enter a number 1-4\n");
            }
            System.out.print("\n");
        }
    }

    private static String alphabeticalSort(String a)
    {
        char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";

        sortCharArray(characters);
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

        sortCharArray(characters);
        determineFrequency(frequency, characters);

        for(int x = characters.length-1; x >= 0; x--)
            list += (characters[x] + " freq: " + frequency[x] + "-");

        String[] statements = list.split("-");
        sortStringArray(statements);

        for(int y = 0; y < statements.length; y++)
            list += (statements[y] + "-");

        return removeRepeats(list);

    }

    private static String charTypes(String a)
    {
        char[] characters = a.toCharArray();
        String list = "";
        int textualCount = 0, numericalCount = 0, wSpaceCount = 0, symbolCount = 0;

        for(int i = 0; i < characters.length; i++)
        {
            if(( characters[i] > 64 && characters[i] < 91 ) || ( characters[i] > 96 && characters[i] < 123))
                textualCount++;
            else if(( characters[i] > 47 && characters[i] < 58))
                numericalCount++;
            else if(characters[i] == 32)
                wSpaceCount++;
            else
                symbolCount++;
        }

        list = "Textual Character count: " + textualCount + "\n" +
               "Numerical Character count: " + numericalCount + "\n" +
               "WhiteSpace Character count: " + wSpaceCount + "\n" +
               "Symbol Character count: " + symbolCount + "\n";

        return list;
    }

    private static String removeRepeats(String a)
    {
        String freqSplit[] = a.split("-");
        String last = "";

        for (int i = 0; i < freqSplit.length; i++) {
            for (int j = i + 1; j < freqSplit.length; j++) {
                if ((freqSplit[i].equals(freqSplit[j])) && (i != j))
                    freqSplit[i] = "";
            }
        }

        for(int i = 0; i < freqSplit.length; i++) {
            if (!freqSplit[i].equals(""))
                last += (freqSplit[i] + "\n");
        }

        return last;
    }

    private static void sortCharArray(char[] a)
    {
        char temp;
        for(int x = 1; x < a.length; x++) {  //For each position of the array, loop through all positions,
            for(int y = x; y > 0; y--) {
                if(a[y] > a[y-1]) {
                    temp = a[y];
                    a[y] = a[y-1];
                    a[y-1] = temp;
                }
            }
        }
    }

    private static void sortStringArray(String[] a)
    {
        String temp;
        for(int x = 1; x < a.length; x++) {
            for(int y = x; y > 0; y--) {         //see method
                if((toNumber(a[y].charAt(8))) > toNumber(a[y-1].charAt(8))) {
                    temp = a[y];        //For each position of the array, loop through all positions,
                    a[y] = a[y-1];      //comparing the last integer of the string ie; [y] = % freq 5; [y-1] = $ freq 4;
                    a[y-1] = temp;      //5, 4, would be the frequencies respectively, so we would then say 5 > 4,
                }                       //and would use a temporary string to hold the value in memory while
            }                           //swapping the entire strings (not just the value), so that it will
        }                               //be properly sorted. NOTE: Using ToNumber, I convert the charAt(8) to an int.
    }

    private static void determineFrequency(int[] a, char[] b)
    {
        for(int j = b.length-1; j >= 0; j--) {
            for(int i = b.length-1; i >= 0; i--) {  //For each position, compare all other positions of the array to it;
                if(b[j] == b[i])                    //if the value at the position is the same as the one being compared,
                    a[j]++;                         //ie, there is another of the same, increase the frequency
            }
        }
    }

    private static int toNumber(char a)
    {
        int number = 0;

        if (a < 58)  //Given that the character is a number;
            number = (int) a - (int) '0'; // Your number will be the difference of the character value of the number
                                          // and the character value of 0
        return number;
    }
}


