import java.util.Scanner;

public class QueueApp {
    private static final int MAX_SIZE = 5;
    private static int[] queue = new int[MAX_SIZE];
    private static int front = 0, rear = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nQueue App Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    enqueue(element);
                    break;
                case 2:
                    int dequeuedElement = dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting the Queue App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void enqueue(int element) {
        if (rear == MAX_SIZE - 1) {
            System.out.println("Queue Overflow. Cannot enqueue element onto a full queue.");
        } else {
            queue[++rear] = element;
            System.out.println("Element " + element + " enqueued.");
        }
    }

    private static int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow. Cannot dequeue element from an empty queue.");
            return -1;
        } else {
            return queue[front++];
        }
    }

    private static void display() {
        if (front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}
