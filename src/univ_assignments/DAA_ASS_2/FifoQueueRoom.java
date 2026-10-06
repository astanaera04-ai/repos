package univ_assignments.DAA_ASS_2;

/**
 * TASK 1 -- the warm-up. You write this one. About 20 lines.
 *
 * A singly linked queue, no triage at all: first come, first served, severity
 * ignored completely. Read ArrayRoom.java first if you haven't -- same
 * interface, already finished, worth 5 minutes before you start this one.
 *
 * WHAT THIS ROOM PROMISES
 *   add() links a new node onto the tail. next() unlinks the head. Nothing
 *   about severity ever enters into it.
 *
 * WHY THIS ONE GRADES ITSELF
 *   Because severity is ignored, a correct FifoQueueRoom produces the exact
 *   same checksum on EVERY barcode: 1^2 + 2^2 + ... + 10000^2. Main checks
 *   this for you automatically -- get that one number right and this task is
 *   done, no comparison against anyone else's code needed.
 *
 * No ready-made collection -- your own Node, a head pointer, a tail pointer,
 * a size counter.
 */
public class FifoQueueRoom implements WaitingRoom {

    private static class Node {
        final Patient p;
        Node next;
        Node(Patient p) { this.p = p; }
    }

    private Node head, tail;
    private int size;

    public void add(Patient p) {
        Node n = new Node(p);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public Patient next() {
        if (head == null) throw new IllegalStateException("empty room");
        Patient p = head.p;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return p;
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }
}
