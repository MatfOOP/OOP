package rs.math.oop1.zd.p170304.filterMapReduce.z03.folksLamdaReusing;

import static rs.math.oop1.zd.p170304.filterMapReduce.z03.folksLamdaReusing.Folks.comrades;
import static rs.math.oop1.zd.p170304.filterMapReduce.z03.folksLamdaReusing.Folks.editors;
import static rs.math.oop1.zd.p170304.filterMapReduce.z03.folksLamdaReusing.Folks.friends;
import java.util.function.Predicate;

public class PickElementsMultipleCollection
{
	public static void main( final String[] args )
	{
		{
			final long countFriendsStartN = friends.stream()
					.filter( name -> name.startsWith( "N" ) ).count();
					
			final long countEditorsStartN = editors.stream()
					.filter( name -> name.startsWith( "N" ) ).count();
					
			final long countComradesStartN = comrades.stream()
					.filter( name -> name.startsWith( "N" ) ).count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countComradesStartN );
			System.out.println( countEditorsStartN );
		}
		
		{
			final Predicate<String> startsWithN = name -> name.startsWith( "N" );
			
			final long countFriendsStartN = friends.stream().filter( startsWithN )
					.count();
			final long countEditorsStartN = editors.stream().filter( startsWithN )
					.count();
			final long countComradesStartN = comrades.stream().filter( startsWithN )
					.count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countComradesStartN );
			System.out.println( countEditorsStartN );
		}
	}
}
