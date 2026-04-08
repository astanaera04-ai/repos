package univ_assignments.ADS_ASS_2;
public class AccountLinkedList {
    private Node head;

    public void addAccount(BankAccount account) {
        Node newNode = new Node(account);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Account added successfully");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        System.out.println("Accounts List:");
        Node current = head;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.data.username +
                    " – Balance: " + current.data.balance);
            current = current.next;
            number++;
        }
    }

    public void searchByUsername(String username) {
        Node current = head;

        while (current != null) {
            if (current.data.username.equals(username)) {
                System.out.println("Found: " + current.data.username +
                        " – Balance: " + current.data.balance);
                return;
            }
            current = current.next;
        }
        System.out.println("Account not found!");
    }
}