package rs.math.oop1.p190300.tokoviObrade.z01.snizenje;

import static rs.math.oop1.p190300.tokoviObrade.z01.snizenje.Prices.prices;
import java.math.BigDecimal;

public class DiscountImperative
{
	public static void main( final String[] args )
	{
		BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
		
		for( BigDecimal price : prices )
		{
			if( price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 )
				totalOfDiscountedPrices = totalOfDiscountedPrices
						.add( price.multiply( BigDecimal.valueOf( 0.9 ) ) );
		}
		System.out
				.println( "Total of discounted prices: " + totalOfDiscountedPrices );
	}
}
