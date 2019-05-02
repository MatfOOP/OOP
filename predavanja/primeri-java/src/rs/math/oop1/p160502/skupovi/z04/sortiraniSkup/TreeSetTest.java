package rs.math.oop1.p160502.skupovi.z04.sortiraniSkup;

/**
 @version 1.10 2004-08-02
 @author Cay Horstmann
 */

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 */
public class TreeSetTest
{
	public static void main( String[] args )
	{
		SortedSet<Item> parts = new TreeSet<>();
		parts.add( new Item( "Toaster", 1234 ) );
		parts.add( new Item( "Printer", 7000 ) );
		parts.add( new Item( "Iron", 7770 ) );
		parts.add( new Item( "Widget", 4562 ) );
		parts.add( new Item( "Modem", 9912 ) );
		System.out.println( parts );
		
		SortedSet<Item> sortByDescription = new TreeSet<Item>(
				new Comparator<Item>()
				{
					public int compare( Item a, Item b )
					{
						String descrA = a.getDescription();
						String descrB = b.getDescription();
						return descrA.compareTo( descrB );
					}
				} );		
		sortByDescription.addAll( parts );
		System.out.println( sortByDescription );

		SortedSet<Item> sortByPartNumber = new TreeSet<Item>(
     (x,y)->{return x.getDescription().compareTo( y.getDescription() );} );
		sortByPartNumber.addAll( parts );
		System.out.println( sortByPartNumber );
		
	}
}

/**
 * An item with a description and a part number.
 */
class Item implements Comparable<Item>
{
	private String description;
	private int partNumber;
	
	/**
	 * Constructs an item.
	 * 
	 * @param aDescription
	 *          the item's description
	 * @param aPartNumber
	 *          the item's part number
	 */
	public Item( String aDescription, int aPartNumber )
	{
		description = aDescription;
		partNumber = aPartNumber;
	}
	
	/**
	 * Gets the description of this item.
	 * 
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	public int getPartNumber()
	{
		return partNumber;
	}

	public String toString()
	{
		return "[descripion=" + description + ", partNumber=" + partNumber + "]" 
	+"\r\n";
	}
	
	public boolean equals( Object otherObject )
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		Item other = (Item) otherObject;
		return description.equals( other.description )
				&& partNumber == other.partNumber;
	}
	
	public int hashCode()
	{
		return 13 * description.hashCode() + 17 * partNumber;
	}
	
	public int compareTo( Item other )
	{
		return partNumber - other.partNumber;
	}
	
}
