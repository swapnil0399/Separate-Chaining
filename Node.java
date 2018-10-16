/**
 *
 * @author swapnil
 */

/*
Node Class: Design of a node in the linked list
*/
public class Node {
    Node next;
    String key;
    long value;

    // Constructors
    Node(String ky, long val) {
        next = null;
        key = ky;
        value = val;
    }

    Node(String ky, long val, Node nxt) {
        next = nxt;
        key = ky;
        value = val;
    }
}
