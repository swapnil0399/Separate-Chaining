/**
 *
 * @author swapnil
 */

public class LinkedList {

    private Node head;  // Head of the list

    // Insert function
    boolean insert(String key, long value) {

        boolean result = false;

        // If the list is empty
        if (head == null) {

            // Create a new Node
            Node newNode = new Node(key, value);
            head = newNode;     // Make head point to the newly created node
            result = true;      // Insertion happened successfully

        } else {

            // Check if the given key already exists or not
            if (find(key) == -1) {

                // If the key doesn't exist in the list insert the key
                // Initialize nodePtr to head
                Node nodePtr = head;

                // Advance all the way to the last node of the list 
                while (nodePtr.next != null) {
                    nodePtr = nodePtr.next;
                } // end of while

                // Create new Node and make the last node point to it
                Node newNode = new Node(key, value);
                nodePtr.next = newNode;
                result = true;      // Insertion happened successfully
            } // end of inner if

        } // end of outer if

        return result;
    } // end of insert

    // Delete function to remove the node in the list
    boolean delete(String ky) {

        boolean result = false;

        // If the list is empty return false
        if (head == null) {
            return result;
        } else if (find(ky) != -1) {    // Check whether the given key is in the list or not

            // If it is in the list
            // Check if head is pointing to it or not
            if (head.key.equals(ky)) {
                // If head is pointing to it
                // make head point to next node
                head = head.next;
            } else {

                // If head is not pointing to it
                // Find the key and remove it from the chain
                Node prevNode = head;

                while (prevNode.next != null) {
                    // Check if the next node is the node that we are looking for
                    if (prevNode.next.key.equals(ky)) {
                        // If next node is the one that we are looking
                        // Assign new value for next
                        prevNode.next = (prevNode.next).next;
                    } else {
                        // If it isn't the one that we are looking for
                        // Advance prevNode to next node
                        prevNode = prevNode.next;
                    } // end for inner if
                } // end for while
            } // end for outer if

            result = true;  //  If everything goes right the node is deleted
        } // end for outer if

        return result;  // Returning the result
    } // end of delete

    // Find function to search a key in the list
    long find(String ky) {

        long result = -1;   // Initialize the result to -1 assuming the key is not found yet

        Node nodePtr = head;

        // If the list is empty the key is not in there
        if (head == null) {
            return result;  // Returning the result
        }

        // While loop to transverse through the list and search if the key is present
        // Condition: Execute till nodePtr is not pointing to the key that 
        // we are looking for and next node is not null
        while (!nodePtr.key.equals(ky) && nodePtr.next != null) {
            nodePtr = nodePtr.next;
        } // end of while

        // If nodePtr is pointing to the key that we are looking for
        if (nodePtr.key.equals(ky)) {
            // Returning the value of the key
            result = nodePtr.value;
        } // end of if

        return result;  // Returning value of the key
    } // end of find

    // Clear function to clear the list
    void clear() {
        head = null;
    } // end of clear

    // Constructor
    LinkedList() {
        head = null;
    }
}
