
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author swapnil
 */
public class main {

    public static void main(String[] args) throws IOException {
        // Reading input from file
        Scanner sc = new Scanner(new File("data.txt"));
        String s = sc.nextLine();
        int M = Integer.parseInt(s); // hash table size
        HashTable HT = new HashTable(M);    // Creating a new HashTable
        s = sc.nextLine();
        int q = Integer.parseInt(s); // number of command lines
        // Loop for reading commands from file
        for (int i = 0; i < q; i++) {
            s = sc.nextLine();
            String[] tokens = s.split(" ");
            String command = tokens[0];     // Type of command
            switch (command) {
                case "I": // insert
                    String key = tokens[1];
                    long val = Long.parseLong(tokens[2]);
                    HT.insert(key, val);    // Inserting key value pair
                    break;
                case "D": // delete
                    key = tokens[1];
                    HT.delete(key);         // Deleting record from HashTable 
                    break;
                case "S": // search
                    key = tokens[1];
                    HT.search(key);         // Looking for a record in table
                    break;
                case "P": // print stats
                    HT.printStats();
                    break;
            } // end of switch
        } // end of for
    } // end of main
}
