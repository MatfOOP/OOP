package rs.math.oop1.zd.p150100.datotekeDirektorijumi.z01.listanje;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ListFiles
{
	public static void main( String[] args ) throws IOException
	{
		Files.list( Paths.get( "." ) ).forEach( System.out::println );
	}
}
