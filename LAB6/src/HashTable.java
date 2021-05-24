/**
 * HashTable.java
 * @author 
 * @author
 * CIS 22C, Lab 6
 */
import java.util.ArrayList;

public class HashTable<T> {
    
    private int numElements;
    private ArrayList<List<T> > Table;

    /**
     * Constructor for the hash 
     * table. Initializes the Table to
     * be sized according to value passed
     * in as a parameter
     * Inserts size empty Lists into the
     * table. Sets numElements to 0
     * @param size the table size
     */
    public HashTable(int size) {
        
    }
       
    /**Accessors*/
    
    /**
     * returns the hash value in the Table
     * for a given Object 
     * @param t the Object
     * @return the index in the Table
     */
    private int hash(T t) {
        int code = t.hashCode();
        return code % Table.size();
    }
    
    /**
     * counts the number of keys at this index
     * @param index the index in the Table
     * @precondition 0 <=  index < Table.length
     * @return the count of keys at this index
     * @throws IndexOutOfBoundsException
     */
    public int countBucket(int index) throws IndexOutOfBoundsException{
        return -1;
    }
    
    /**
     * returns total number of keys in the Table
     * @return total number of keys
     */
    public int getNumElements() {
        return -1;
    }
    
    /**
     * Accesses a specified key in the Table
     * @param t the key to search for
     * @return  the value to which the specified key is mapped, 
     * or null if this table contains no mapping for the key. 
     * @precondition t != null
     * @throws NullPointerException if the specified key is null
     */
    public T get(T t) throws NullPointerException{
        return null;
    }
    
    /**
     * Determines whether a specified key is in 
     * the Table
     * @param t the key to search for
     * @return  whether the key is in the Table 
     * @precondition t != null
     * @throws NullPointerException if the specified key is null
     */
    public boolean contains(T t) throws NullPointerException{
        return false;
    }
    
     
    /**Mutators*/
    
    /**
     * Inserts a new element in the Table
     * at the end of the chain in the bucket
     * to which the key is mapped
     * @param t the key to insert
     * @precondition t != null
     * @throws NullPointerException for a null key
     */
    public void insert(T t) throws NullPointerException{  
        
    }  
     
     
    /**
     * removes the key t from the Table
     * calls the hash method on the key to
     * determine correct placement
     * has no effect if t is not in
     * the Table or for a null argument          
     * @param t the key to remove
     * @throws NullPointerException if the key is null
     */
    public void remove(T t) throws NullPointerException {
        
    }
    
    /**
     * Clears this hash table so that it contains no keys.
     */
    public void clear() {
        
    }

    /**Additional Methods*/

    /**
     * Prints all the keys at a specified
     * bucket in the Table. Tach key displayed
     * on its own line, with a blank line 
     * separating each key
     * Above the keys, prints the message
     * "Printing bucket #<bucket>:"
     * Note that there is no <> in the output
     * @param bucket the index in the Table
     */
    public void printBucket(int bucket) {
        
    }
        
    /**
     * Prints the first key at each bucket
     * along with a count of the total keys
     * with the message "+ <count> -1 more 
     * at this bucket." Each bucket separated
     * with two blank lines. When the bucket is 
     * empty, prints the message "This bucket
     * is empty." followed by two blank lines
     */
    public void printTable(){
         
     }
    
    /**
     * Starting at the first bucket, and continuing
     * in order until the last bucket, concatenates
     * all elements at all buckets into one String
     */
    @Override public String toString() {
        
    }
    
}