import java.util.Scanner;

public class StackApp {
    private static final int MAX_SIZE = 5;
    private static int[] stack = new int[MAX_SIZE];
    private static int top = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStack App Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    push(element);
                    break;
                case 2:
                    int poppedElement = pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting the Stack App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void push(int element) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack Overflow. Cannot push element onto a full stack.");
        } else {
            stack[++top] = element;
            System.out.println("Element " + element + " pushed onto the stack.");
        }
    }

    private static int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow. Cannot pop element from an empty stack.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    private static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
