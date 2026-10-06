package univ_assignments.DAA_ASS_2;

/**
 * TASK 2. You write this one. About 25 lines.
 *
 * A singly linked list kept in call order at all times.
 *
 * WHAT THIS ROOM PROMISES
 *   Walking from head to tail gives exactly the order the doctor will call
 *   the patients in. So next() is trivial -- the head is the answer.
 *   Everything is paid for in add().
 *
 * THE PART THAT DECIDES YOUR MARK
 *   Patients of the same severity are not interchangeable: the one who
 *   arrived earlier is called earlier. Patient.before(a, b) already knows
 *   the whole rule -- ask it, and never compare severities yourself. Work
 *   out for yourself where the walk has to stop: stop one node too early and
 *   every tie comes out backwards, and your list row stops matching the
 *   given array row.
 *
 * No ready-made collection -- your own Node, a head pointer and a size
 * counter.
 */
public class SortedListRoom implements WaitingRoom {

    private static class Node {
        final Patient p;
        Node next;
        Node(Patient p) { this.p = p; }
    }

    private Node head;
    private int size;

    public void add(Patient p) {
        Node n = new Node(p);
        if (head == null || Patient.before(p, head.p)) {
            // belongs in front of everybody (or the list is empty)
            n.next = head;
            head = n;
        } else {
            Node cur = head;
            // stop when the node after cur must be seen before p (or there is none);
            // on a tie, Patient.before(p, x) is false for the earlier arrival x, so we walk past it
            while (cur.next != null && !Patient.before(p, cur.next.p)) {
                cur = cur.next;
            }
            n.next = cur.next;
            cur.next = n;
        }
        size++;
    }

    public Patient next() {
        if (head == null) throw new IllegalStateException("empty room");
        Patient p = head.p;
        head = head.next;
        size--;
        return p;
    }

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    /** GIVEN -- the list from head to tail, used by the trace. Do not change. */
    public String layout() {
        StringBuilder s = new StringBuilder("[");
        for (Node c = head; c != null; c = c.next) {
            if (c != head) s.append(' ');
            s.append('#').append(c.p.id()).append('s').append(c.p.severity());
        }
        return s.append(']').toString();
    }
}
