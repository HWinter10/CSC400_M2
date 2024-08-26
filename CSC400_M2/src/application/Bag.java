package application;

//-------------------------------------------
//Pseudocode
//Author: Hailey King-Winterton
//Due Date: 08/18/2024
//-------------------------------------------
//Start
//		1. initialize map 
//		2. create add method - previous assignment requirements
//			- check if in bag
//			- add or increment
//		3. create remove method - previous assignment requirements
//			- check if in bag
//			- if 1, remove 1
//			- if >1, decrement
//		4. create contains method - previous assignment requirements
//			- check if in bag
//			- return boolean
//		5. create count method - previous assignment requirements
//			- return item count if in bag
//		6. create print method - previous assignment requirements
//			- print all items & their count
//		7. create size method - new assignment requirements
//			- initialize to 0
//			- loop through items
//			- add values to total & return
//		8. create merge method - new assignment requirements
//			- loop through items
//			- merge into bag 1 with item count
//		9. create distinct method - new assignment requirements
//			- initialize distinct bag
//			- loop through keys & add to bag
//			- return distinct bag
//End
//-------------------------------------------

import java.util.HashMap;
import java.util.Map;


public class Bag<T> {
    private final Map<T, Integer> itemCount;

    public Bag() {
        itemCount = new HashMap<>();
    }

    // Add method
    public void add(T item) {
        itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
    }

    // Remove method
    public void remove(T item) {
        if (itemCount.containsKey(item)) {
            int count = itemCount.get(item);
            if (count == 1) {
                itemCount.remove(item);
            } else {
                itemCount.put(item, count - 1);
            }
        }
    }

    // Contains method
    public boolean contains(T item) {
        return itemCount.containsKey(item);
    }

    // Count method
    public int count(T item) {
        return itemCount.getOrDefault(item, 0);
    }

    // Print method
    public void printBag() {
        for (T item : itemCount.keySet()) {
            System.out.println(item + ": " + itemCount.get(item));
        }
    }

    // New method: size
    public int size() {
        int total = 0;
        for (int count : itemCount.values()) {
            total += count;
        }
        return total;
    }

    // New method: merge
    public void merge(Bag<T> otherBag) {
    	Bag<T> mergedBag = new Bag<>();
    	
        for (Map.Entry<T, Integer> entry : otherBag.itemCount.entrySet()) {
            T item = entry.getKey();
            int count = entry.getValue();
            itemCount.put(item, itemCount.getOrDefault(item, 0) + count);
        }
    }

    // New method: distinct
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (T item : itemCount.keySet()) {
            distinctBag.add(item);
        }
        return distinctBag;
    }
}
