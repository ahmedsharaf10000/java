import java.util.Scanner;

public class PriorityQueueApp {
    private static final int MAX_SIZE = 5;
    private static int[] priorityQueue = new int[MAX_SIZE];
    private static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPriority Queue App Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Remove (Highest Priority)");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    insert(element);
                    break;
                case 2:
                    int removedElement = remove();
                    if (removedElement != -1) {
                        System.out.println("Removed element with highest priority: " + removedElement);
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting the Priority Queue App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void insert(int element) {
        if (size == MAX_SIZE) {
            System.out.println("Priority Queue is full. Cannot insert element.");
        } else {
            priorityQueue[size] = element;
            heapifyUp(size);
            size++;
            System.out.println("Element " + element + " inserted with priority.");
        }
    }

    private static int remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty. Cannot remove element.");
            return -1;
        } else {
            int root = priorityQueue[0];
            priorityQueue[0] = priorityQueue[size - 1];
            heapifyDown(0);
            size--;
            return root;
        }
    }

    private static void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
        } else {
            System.out.print("Priority Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(priorityQueue[i] + " ");
            }
            System.out.println();
        }
    }

    private static void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (priorityQueue[index] > priorityQueue[parent]) {
                // Swap if the current element is greater than its parent
                int temp = priorityQueue[index];
                priorityQueue[index] = priorityQueue[parent];
                priorityQueue[parent] = temp;
            } else {
                break;
            }
            index = parent;
        }
    }

    private static void heapifyDown(int index) {
        int leftChild, rightChild, largerChild;

        while (index < size / 2) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;

            if (rightChild < size && priorityQueue[leftChild] < priorityQueue[rightChild]) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (priorityQueue[index] < priorityQueue[largerChild]) {
                // Swap if the current element is smaller than its larger child
                int temp = priorityQueue[index];
                priorityQueue[index] = priorityQueue[largerChild];
                priorityQueue[largerChild] = temp;
            } else {
                break;
            }

            index = largerChild;
        }
    }
}
