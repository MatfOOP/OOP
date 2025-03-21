package rs.math.oop1.z080301.uredjenje.z02.geometrija;

import java.awt.Graphics;

public class Tekst extends GeometrijskiObjekat implements Prikaz
{
	private String sadrzaj = "tra la la";
	
	public Tekst( String s )
	{
		super("");
		sadrzaj = s;
	}
	
	public Tekst()
	{
		this("");
	}
	
	@Override
	public void prikaziSe()
	{
		System.out.print( "Tekst: " + sadrzaj );
	}
	
	@Override
	public void prikaziSe( Graphics g )
	{
		g.drawString( sadrzaj, 100, 100 );
	}
	
}
