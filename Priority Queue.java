class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to find and delete a node with a specific value
    public void findAndDelete(int key) {
        Node current = head;
        Node prev = null;

        // Search for the node with the specified key
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the node with the key is found, delete it
        if (current != null) {
            // If the node to be deleted is the head
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
            System.out.println("Node with key " + key + " deleted.");
        } else {
            System.out.println("Node with key " + key + " not found.");
        }
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Insert elements into the linked list
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        System.out.print("Original Linked List: ");
        linkedList.display();

        // Find and delete a node with a specific value
        linkedList.findAndDelete(2);

        System.out.print("Linked List after deletion: ");
        linkedList.display();
    }
}
