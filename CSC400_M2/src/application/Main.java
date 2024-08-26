package application;

// -------------------------------------------
// Pseudocode
// Author: Hailey King-Winterton
// Due Date: 08/18/2024
// -------------------------------------------
// Start
//		1. initialize bag
//		2. add contents for both bags
//		3. display menu
//			1. print bag 1
//			2. print bag 2
//			3. contains (bag 1) - previous assignment requirements
//			4. count (bag 1) - previous assignment requirements
//			5. remove (bag 1) - previous assignment requirements
//			6. print size bag 1 - new assigment requirements
//			7. print size bag2 - new assigment requirements
//			8. merge bag 2 into bag 1 - new assigment requirements
//			9. print merged bag 1 contents - new assigment requirements
//			10. print distinct elements of merged bag - new assigment requirements
//			11. exit
// 		4. case set up for menu
// End
// -------------------------------------------
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Adding items to bag1
        bag1.add("apple");
        bag1.add("lemon");
        bag1.add("blueberry");
        bag1.add("lemon");

        // Adding items to bag2
        bag2.add("kiwi");
        bag2.add("apple");
        bag2.add("grape");
        bag2.add("apple");

        // Scanner object
        Scanner scanner = new Scanner(System.in);

     // Menu options
        while (true) {
            System.out.println("-----------------");
            System.out.println("Menu:");
            System.out.println("-----------------");
            System.out.println("1. Print contents of bag 1.");
            System.out.println("2. Print contents of bag 2.");
            System.out.println("3. Contains test (bag 1).");
            System.out.println("4. Count test (bag 1).");
            System.out.println("5. Remove test (bag 1).");
            System.out.println("6. Print size of bag 1.");
            System.out.println("7. Print size of bag 2.");
            System.out.println("8. Merge bag 2 into bag 1.");
            System.out.println("9. Print merged bag 1 contents.");
            System.out.println("10. Print distinct elements from bag 1.");
            System.out.println("11. Exit.");
            System.out.println("-----------------");

            System.out.print("Choose an option: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1: // Print contents of bag 1
                        System.out.println("Bag 1 contents:");
                        bag1.printBag();
                        break;
                    case 2: // Print contents of bag 2
                        System.out.println("Bag 2 contents:");
                        bag2.printBag();
                        break;
                    case 3: // Contains test (bag 1)
                        System.out.print("Check if bag 1 contains item (case sensitive): ");
                        String containsElement = scanner.nextLine();
                        boolean containsItem = bag1.contains(containsElement);
                        System.out.println("Bag 1 contains '" + containsElement + "': " + containsItem);
                        break;
                    case 4: // Count test (bag 1)
                        System.out.print("Get count of item in bag 1 (case sensitive): ");
                        String countElement = scanner.nextLine();
                        System.out.println("Count of '" + countElement + "' in bag 1: " + bag1.count(countElement));
                        break;
                    case 5: // Remove test (bag 1)
                        System.out.print("Remove item from bag 1 (case sensitive): ");
                        String removeElement = scanner.nextLine();
                        bag1.remove(removeElement);
                        System.out.println("Updated bag 1 contents:");
                        bag1.printBag();
                        break;
                    case 6: // Print size of bag 1
                        System.out.println("Size of bag 1: " + bag1.size());
                        break;
                    case 7: // Print size of bag 2
                        System.out.println("Size of bag 2: " + bag2.size());
                        break;
                    case 8: // Merge bag 2 into bag 1
                        bag1.merge(bag2);
                        System.out.println("Bag 2 has been merged into bag 1.");
                        break;
                    case 9: // Print merged bag 1 contents
                        System.out.println("Merged bag 1 contents:");
                        bag1.printBag();
                        break;
                    case 10: // Print distinct elements from bag 1
                        Bag<String> distinctBag = bag1.distinct();
                        System.out.println("Distinct elements in bag 1:");
                        distinctBag.printBag();
                        break;
                    case 11: // Exit
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) { // Error handling
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}