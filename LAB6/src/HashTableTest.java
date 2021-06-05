
/**
 * HashTableTest.java
 * 
 * @author
 * @author CIS 22C, Lab 6 TODO: Add more method calls!
 */

public class HashTableTest {
	public static void main(String[] args) {

/////////////////////////////////////////////		
//Default Constructor 
/////////////////////////////////////////////
		System.out.println("***Testing default constructor***");
		HashTable<Movie> defaultConstructor = new HashTable<Movie>(1);
		Movie bond0 = new Movie("Spiderman", "Test actor", 1962, 59.5);
		System.out.println("Default constructor size value: (0) " + defaultConstructor.getNumElements());
		defaultConstructor.insert(bond0);
		System.out.println("Default constructor size value: (1) " + defaultConstructor.getNumElements());
		// System.out.println("get value: () " + defaultConstructor.get(bond0));

		HashTable<Movie> t = new HashTable<Movie>(20);
		Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
		Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
		Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
		Movie bond4 = new Movie("Thunderball", "Kevin McClory", 1965, 141.2);
		Movie bond5 = new Movie("Casino Royale", "Ken Hughes", 1967, 41.7);
		Movie bond6 = new Movie("You Only Live Twice", "Lewis Gilbert", 1967, 111.6);
		Movie bond7 = new Movie("On Her Majesty's Secret Service", "Peter R. Hunt", 1969, 82.0);
		Movie bond8 = new Movie("Diamonds are Forever", "Guy Hamilton", 1971, 116.0);
		Movie bond9 = new Movie("Live and Let Die", "Guy Hamilton", 1973, 161.8);
		Movie bond10 = new Movie("The Man with the Golden Gun", "Guy Hamilton", 1974, 97.6);

/////////////////////////////////////////////		
//insert()
/////////////////////////////////////////////
		System.out.println("\n\n***Testing Insert and toString***");
		t.insert(bond1);
		t.insert(bond2);
		t.insert(bond3);
		t.insert(bond4);
		t.insert(bond5);
		t.insert(bond6);
		t.insert(bond7);
		t.insert(bond8);
		t.insert(bond9);
		t.insert(bond10);
		System.out.print(t);
		System.out.print("\nInserted 10 movies, size should be 10: " + t.getNumElements());
		System.out.print("\nShould print error, inserting null: ");
		try {
			t.insert(null);
		} catch (NullPointerException e) {
			System.out.println("\n" + e);
		}
		// ;

/////////////////////////////////////////////		
//get()
/////////////////////////////////////////////
		System.out.println("\n***Testing Get***\n");
		Movie m = new Movie("Diamonds are Forever", "Guy Hamilton");
		Movie n = new Movie("MovieNotFound", "Fake Actor");
		m = t.get(m);
		if (m != null) {
			System.out.println("Get did locate Diamonds Are Forever:");
			System.out.println(m);
		} else {
			System.out.println("Get did not locate MovieNotFound");
		}

		try {
			n = t.get(n);
		} catch (NullPointerException e) {
			System.out.println("\n" + e);
		}

		System.out.println("\n***Testing PrintBucket for Index 19***\n");
		t.printBucket(19);

		System.out.println("\n***Testing Remove***\n");
		t.remove(bond9);
		System.out.println(bond9.getTitle() + " should be removed from this index: \n");
		t.printBucket(19);

		boolean inTable = t.contains(bond9);
		inTable = t.contains(bond9);
		if (inTable) {
			System.out.println(bond9.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond9.getTitle() + " is not stored in the table");
		}

		System.out.println("\n***Testing printTable***\n");
		t.printTable();
		HashTable<Movie> tEmpty = new HashTable<Movie>(2);
		System.out.println("Print an empty table: ");
		tEmpty.printTable();
/////////////////////////////////////////////		
//contains()
/////////////////////////////////////////////
		System.out.println("\n***Testing contains***\n");
		System.out.print("Contains: (true) ");
		System.out.println(t.contains(m));
		System.out.print("Contains: (false) - should print error: ");
		try {
			System.out.println(t.contains(n));
		} catch (NullPointerException e) {
			System.out.println("\n" + e);
		}

		System.out.println("\n***Testing CountBucket***\n");
		int count = t.countBucket(19);
		System.out.println("There are " + count + " movies at bucket 19");
		System.out.print("Should print error when counting out of bounds: ");
		try {
			count = t.countBucket(20);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\n" + e);
		}

		System.out.println("\n***Testing Contains***\n");
		inTable = t.contains(bond9);
		if (inTable) {
			System.out.println(bond9.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond9.getTitle() + " is not stored in the table");
		}

		System.out.println("\n***Testing Clear()***\n");
		System.out.println("Table size before clear (9): " + t.getNumElements());
		t.clear();
		System.out.println("Table size after clear (0): " + t.getNumElements());
		System.out.println("\nTable size before clear on empty table (0): " + tEmpty.getNumElements());
		tEmpty.clear();
		System.out.println("Table size after clear on empty table (0): " + tEmpty.getNumElements());

	}
}
