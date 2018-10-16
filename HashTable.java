
import static java.lang.Integer.remainderUnsigned;

/**
 *
 * @author swapnil
 */
public class HashTable {

    LinkedList[] L; // uses an array of LinkedLists
    int tableSize;
    int entries;
    
    // Constructor
    HashTable(int size) {
        tableSize = size;
        entries = 0;

        // Initializing the array of linked list for every list
        L = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            // Initialization
            L[i] = new LinkedList();

        } // end of for
    } // end of constructor

    // Hash function
    int hash(String ky, int tableSize) {

        int hashVal;
        int temp = 0;

        // for every character in key, add the ascii value to 31 * index
        // for example for key ABC, the following loop will result in
        // the following value of temp (((31 * 0) + 65) * 31 + 66) * 31 + 67)
        // It will automatically implement the mod of 2^32 because overflow of int
        // resets it to minimum value of int, i.e., -2^32
        for (int i = 0; i < ky.length(); i++) {
            temp = 31 * temp + ky.charAt(i);    // Horner's Rule
        } // end of for

        // Calculating mod of temp and tableSize using remainderUnsigned
        // This method takes both values as unsigned int, so if temp is negative due to overflow
        // It will consider it as a positive and provide result accordingly
        hashVal = remainderUnsigned(temp, tableSize);
        return hashVal;     // Returning the calculated Hash
    } // end of hash

    // insert function
    boolean insert(String key, long val) {

        int hashVal = hash(key, tableSize);     // Calculate hash for index of array
        boolean success = L[hashVal].insert(key, val);  // insert the key value pair at hashVal index

        // If the insertion happens successfully
        if (success) {
            entries++;  // Increment number of entries by 1
            System.out.printf("Key %s inserted on list %d\n", key, hashVal);
            return true;
        } else {    // If insertion fails
            System.out.printf("Key %s already exists\n", key);
            return false;
        } // end of if else
    } // end of insert

    // delete function
    boolean delete(String key) {

        int hasVal = hash(key, tableSize);  // Calculate hash for index of array
        boolean result = L[hasVal].delete(key); // delete the record from the table

        // If deletion is successful
        if (result) {
            System.out.printf("Key %s deleted from list %d\n", key, hasVal);
            entries--;  // Decrement number of entries by 1
        } else {    // If deletion fails
            System.out.printf("Key %s doesn't exist\n", key);
        } // end of if else

        return result;  // Return the result of deletion
    } // end of delete

    // search function
    long search(String key) {

        int hashValue = hash(key, tableSize);   // Calculate hash for index of array
        long value = L[hashValue].find(key);    // search for the key at hashValue index of the table

        // If the key is found
        if (value != -1) {
            // Print the value for the respective key
            System.out.printf("Key %s found on list %d, record = %d\n", key, hashValue, value);
            return value;   // Return the value
        } else {    // If the key is not found in the list
            System.out.printf("Key %s doesn't exist\n", key);
            return -1;      // Return -1
        } // end of if else
    } // end of search

    // clearTable function 
    void clearTable() {

        // for loop to clear the list at every index of the table
        for (int i = 0; i < tableSize; i++) {
            L[i].clear();   // Calling clear method for linked list at index i
        }

        entries = 0;    // Reset number of records to 0
    } // end of clearTable

    // size function
    int size() {
        return entries;     // Return number of records that are present in the table
    }

    // printStats function
    void printStats() {
        System.out.printf("Number of records in table = %d\n", entries);
    }
}
