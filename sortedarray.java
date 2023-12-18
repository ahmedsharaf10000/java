public class HighArray {
    private long[] arr;   // Array to store elements
    private int nElems;    // Number of elements in the array

    // Constructor to initialize the array
    public HighArray(int maxSize) {
        arr = new long[maxSize];
        nElems = 0;
    }

    // Function to search for a key
    public boolean find(long key) {
        for (int i = 0; i < nElems; i++) {
            if (arr[i] == key) {
                return true;  // Key found
            }
        }
        return false;  // Key not found
    }

    // Function to insert an element at the end
    public void insert(long value) {
        arr[nElems] = value;
        nElems++;
    }

    // Function to delete an element
    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] == value) {
                break;  // Found the element to delete
            }
        }

        if (i == nElems) {
            return false;  // Element not found, cannot delete
        } else {
            // Move higher elements down
            for (int j = i; j < nElems - 1; j++) {
                arr[j] = arr[j + 1];
            }
            nElems--;  // Decrease the number of elements
            return true;  // Element deleted successfully
        }
    }

    // Function to display the elements in the array
    public void display() {
        System.out.print("Array: ");
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage of the HighArray class
        HighArray highArray = new HighArray(10);

        highArray.insert(10);
        highArray.insert(20);
        highArray.insert(30);
        highArray.insert(40);
        highArray.insert(50);

        highArray.display(); // Array: 10 20 30 40 50

        System.out.println("Search for key 30: " + highArray.find(30)); // true

        highArray.delete(30);
        highArray.display(); // Array: 10 20 40 50

        System.out.println("Search for key 30 after deletion: " + highArray.find(30)); // false
    }
}
