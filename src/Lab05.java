import java.util.Scanner;
// ****************************************************************
// Lab05.java
//
// Provide a menu-driven program for processing a random integer array.
// @completed by: Muhammad Andhika Prasetya - 2206031302
// ****************************************************************
public class Lab05 {
    // ------------------------------------------------------------------
    // Creates a random list of integers, then repeatedly print the menu
    // and do what the user asks until they quit.
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        int[] list = new int[10]; //initial default array
        Scanner scan = new Scanner(System.in);
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0) {
            int loc;
            switch (choice) {
                case 1 -> {
                    System.out.println("How many elements?");
                    int size = scan.nextInt();
                    list = new int[size];
                    randomize(list);
                    System.out.println("A new list with " + size + " of random elements has been created.");
                }
                case 2 -> {
                    selectionSort(list);
                    System.out.println("The list has been sorted.");
                }
                case 3 -> {
                    System.out.print("Enter the value to look for: ");
                    loc = linearSearch(list, scan.nextInt());
                    if (loc != -1)
                        System.out.println("Found at location " + loc);
                    else
                        System.out.println("Not in list");
                }
                case 4 -> {
                    System.out.println("Here is the list: ");
                    printList(list);
                }
                default -> System.out.println("Sorry, invalid choice");
            }
            printMenu();
            choice = scan.nextInt();
        }
        System.out.println("Bye!");
    }

    // -------------------------------------
    // Print the menu of user's choices.
    // -------------------------------------
    public static void printMenu() {
        System.out.println();
        System.out.println("0: Quit");
        System.out.println("1: Create a new list of random elements");
        System.out.println("2: Sort the list using selection sort");
        System.out.println("3: Find an element in the list using linear search");
        System.out.println("4: Print the list");
        System.out.print("\nEnter your choice: ");
    }

    // ------------------------------------------------------------------
    // Fills the array with random integers between 1 and 1000, inclusive
    // ------------------------------------------------------------------
    public static void randomize(int[] list) {
        for (int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * 1000) + 1;
    }

    // ----------------------------------------
    // Prints array elements with indices
    // ----------------------------------------
    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.printf("[%d]:\t%d\n", i, list[i]);
    }

    // -----------------------------------------------------------------
    // Returns the index of the first occurrence of target in the list, -1
    // if target does not appear in the list.
    // -----------------------------------------------------------------
    public static int linearSearch(int[] list, int target) {
        return linearSearchRec(list, target, 0);
    }

    // -----------------------------------------------------------------
    // Recursive implementation of the sequential search -- searches
    // for target starting at index lo.
    // Is this method tail-recursive?
    // -----------------------------------------------------------------
    private static int linearSearchRec(int[] list, int target, int lo) {
        if (lo >= list.length) // target not found
            return -1;
        else if (list[lo] == target) // target found
            return lo;
        else // keep searching recursively
            return linearSearchRec(list, target, lo + 1);
    }

    // ------------------------------------------------------------------------
    // Sorts the list into ascending order using the selection sort algorithm.
    // ------------------------------------------------------------------------
    public static void selectionSort(int[] list) {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            //find the smallest element in list starting at location i
            minIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j] < list[minIndex])
                    minIndex = j;
            //swap list[i] with the smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
}
