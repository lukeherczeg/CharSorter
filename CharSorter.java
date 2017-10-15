import java.util.*;

public class CharSorter {
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Welcome to Character Sorting Program\nPlease input a string to be sorted");
        Scanner input = new Scanner(System.in);
        String userLine = input.nextLine();
        System.out.print("\n");
        // ËÏö
        while (running) {
            System.out.println( "Please select the option you would like to see\n\n" + //This is the menu
                                "1. Display character frequencies alphabetically\n" +
                                "2. Display sorted frequencies\n" +
                                "3. Show types of character frequencies\n" +
                                "4. Exit " );

            Scanner newInput = new Scanner(System.in);
            int choice = -1;                                        //Set choice equal to a redundant value not being used

            try {choice = newInput.nextInt();}                      //Simple try-catch to catch wrong input and keep the program running
            catch (InputMismatchException wrong)                    //going forward to the switch.
                {/*see default of switch below*/}

            switch (choice) {                                      //Switch statement; depending on input, the
                case 1:                                            //system will print the userLine after applying a method to it
                    System.out.println(alphabeticalSort(userLine));//In a while loop with boolean running, set false if
                    break;                                         //and only if 4, or Exit, is chosen.
                case 2:
                    System.out.println("The sorted by frequency characters are:\n\n" + frequencySort(userLine));
                    break;
                case 3:
                    System.out.println(charTypes(userLine));
                    break;
                case 4:
                    running = false;
                    System.out.println("\nCharacter Sorter Exited Successfully");
                    break;
                default:                                           // default will be the invalid input
                    System.out.println("Error, bad input, please enter a number 1-4\n");
            }
            System.out.print("\n");
        }
    }

    private static String alphabeticalSort(String a) {
        char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";

        sortCharArray(characters);                                     //See method sortCharArray
        determineFrequency(frequency, characters);                     //See method determineFrequency

        for (int x = characters.length - 1; x >= 0; x--)               //Loop through char array, make concatenated string
            list += (characters[x] + " freq: " + frequency[x] + "--"); //Add double dashes to use split function and
                                                                       //and make a string array to loop through
        list = removeRepeats(list);       //See removeRepeats method

        String[] statements = list.split("--");        //Split at double dashes, won't affect code if -- are used, since
        list = "";   //Reset list                      //the program only analyzes one character at a time.

        for (int y = 0; y < statements.length; y++)          //Loop through new char array, concatenating a string but adding
            list += (statements[y] + "\n");                  //\n so that the final list will be formatted correctly

        return list;
    }

    private static String frequencySort(String a) {                     //Does the same thing as alphabetical sort
        char[] characters = a.toCharArray();                            //up until
        int[] frequency = new int[characters.length];
        String list = "";

        sortCharArray(characters);
        determineFrequency(frequency, characters);

        for (int x = characters.length - 1; x >= 0; x--)
            list += (characters[x] + " freq: " + frequency[x] + "--");

        list = removeRepeats(list);

        String[] statements = list.split("--");
        list = "";

        sortStringArray(statements);

        for (int y = 0; y < statements.length; y++)
            list += (statements[y] + "\n");

        return list;

    }

    private static String charTypes(String a) {
        char[] characters = a.toCharArray();
        String list = "";
        int textualCount = 0, numericalCount = 0, wSpaceCount = 0, symbolCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if ((characters[i] > 64 && characters[i] < 91) || (characters[i] > 96 && characters[i] < 123))
                textualCount++;
            else if ((characters[i] > 47 && characters[i] < 58))
                numericalCount++;
            else if (characters[i] == 32)
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

    private static String removeRepeats(String a) {
        String freqSplit[] = a.split("--");
        String last = "";

        for (int i = 0; i < freqSplit.length; i++) {
            for (int j = i + 1; j < freqSplit.length; j++) {
                if ((freqSplit[i].equals(freqSplit[j])) && (i != j))
                    freqSplit[i] = "";
            }
        }

        for (int i = 0; i < freqSplit.length; i++) {
            if (!freqSplit[i].equals("") && (i < freqSplit.length - 1))
                last += (freqSplit[i] + "--");
            else
                last += freqSplit[i];
        }

        return last;
    }

    private static void sortCharArray(char[] a) {
        char temp;
        for (int x = 1; x < a.length; x++) {            //For each position of the array, loop through all positions,
            for (int y = x; y > 0; y--) {               //comparing each character with every other character
                if (a[y] > a[y - 1]) {                  //and if the current is greater, use temporary variable to hold and
                    temp = a[y];                        //switch the current and the previous values.
                    a[y] = a[y - 1];
                    a[y - 1] = temp;
                }
            }
        }
    }

    private static void sortStringArray(String[] a)
    {                                                     //See below, discusses the method
        String temp;
        for (int x = 1; x < a.length; x++) {
            for (int y = x; y > 0; y--) {
                if ((toNumber(a[y].substring(8))) > toNumber(a[y-1].substring(8))) {
                    temp = a[y];                          //For each position of the array, loop through all positions,
                    a[y] = a[y - 1];                      //comparing the last integer of the string (which is always 8) ie; [y] = % freq 554; [y-1] = $ freq 445;
                    a[y - 1] = temp;                      //554, 445, would be the frequencies respectively, so we would then say 554 > 445,
                }                                         //and would use a temporary string to hold the value in memory while
            }                                             //swapping the entire strings (not just the value), so that it will
        }                                                 //be properly sorted. NOTE: Using ToNumber, I convert the charAt(8) to an int.
    }

    private static int toNumber(String a)
    {                                                     //For this method, I first turn the string into a charArray,
        String concatNumber = "";                         //then given that the character has a numerical ascii value,
        char[] b = a.toCharArray();                       //the number will be the difference of the character value of
                                                          //the number and the character value of 0.
        for (int i = 0; i < b.length; i++) {              //Casting characters as ints, I am able to save and add the
            if (b[i] < 58)                                //integer from the beginning of its position to the end on a
                concatNumber += (int) b[i] - (int) '0';   //concatenated string, which I then parse into an int and return.
        }                                                 //Example: 156 would loop 3 times, concatenating 1, 5, and 6,
        return Integer.parseInt(concatNumber);            //and then parsing the String back to the number 156.
    }

    private static void determineFrequency(int[] a, char[] b)
    {
        for (int j = b.length - 1; j >= 0; j--) {
            for (int i = b.length - 1; i >= 0; i--) {  //For each position, compare all other positions of the array to it;
                if (b[j] == b[i])                      //if the value at the position is the same as the one being compared,
                    a[j]++;                            //ie, there is another of the same, increase the frequency
            }
        }
    }

    public static String[] prepareConcatenatedString(String a)
    {
        char[] characters = a.toCharArray();
        int[] frequency = new int[characters.length];
        String list = "";

        sortCharArray(characters);                                     //See method sortCharArray
        determineFrequency(frequency, characters);                     //See method determineFrequency

        for (int x = characters.length - 1; x >= 0; x--)               //Loop through char array, make concatenated string
            list += (characters[x] + " freq: " + frequency[x] + "--"); //Add double dashes to use split function and
        //and make a string array to loop through
        list = removeRepeats(list);       //See removeRepeats method

        String[] statements = list.split("--");        //Split at double dashes, won't affect code if -- are used, since
        //list = "";         //Reset list                      //the program only analyzes one character at a time.

        return statements;
    }
}