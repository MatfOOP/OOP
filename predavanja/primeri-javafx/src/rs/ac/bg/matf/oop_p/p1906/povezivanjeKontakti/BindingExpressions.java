package rs.ac.bg.matf.oop_p.p1906.povezivanjeKontakti;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Binding Expressions
 * 
 * @author cdea
 */
public class BindingExpressions
{
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main(String[] args)
	{
		System.out.println("Chapter 1-10 Binding Expressions\n");
		System.out.println("Binding a Contact bean [Bi-directional binding]");
		Contact contact = new Contact("John", "Doe");
		StringProperty fname = new SimpleStringProperty();
		fname.bindBidirectional(contact.firstNameProperty());
		StringProperty lname = new SimpleStringProperty();
		lname.bindBidirectional(contact.lastNameProperty());
		System.out.println("Current - StringProperty values : " + fname.getValue()
				+ " " + lname.getValue());
		System.out.println("Current - Contact values : " + contact.getFirstName()
				+ " " + contact.getLastName());
		System.out.println("Modifying StringProperty values");
		fname.setValue("Jane");
		lname.setValue("Deer");
		System.out.println("After - StringProperty values : " + fname.getValue()
				+ " " + lname.getValue());
		System.out.println("After - Contact values : " + contact.getFirstName()
				+ " " + contact.getLastName());
		System.out.println();
		System.out.println("A Area of a Rectangle [High level Fluent API]");
		// Area = width * height
		final IntegerProperty width = new SimpleIntegerProperty(10);
		final IntegerProperty height = new SimpleIntegerProperty(10);
		NumberBinding area = width.multiply(height);
		System.out.println("Current - Width and Height : " + width.get() + " "
				+ height.get());
		System.out.println("Current - Area of the Rectangle: " + area.getValue());
		System.out.println("Modifying width and height");
		width.set(100);
		height.set(700);
		System.out.println("After - Width and Height : " + width.get() + " "
				+ height.get());
		System.out.println("After - Area of the Rectangle: " + area.getValue());
		System.out.println();
		System.out.println("A Volume of a Sphere [low level API]");
		// volume = 4/3 * pi r^3
		final DoubleProperty radius = new SimpleDoubleProperty(2);
		DoubleBinding volumeOfSphere = new DoubleBinding() {
			{
				super.bind(radius);
			}

			@Override
			protected double computeValue()
			{
				return (4 / 3 * Math.PI * Math.pow(radius.get(), 3));
			}
		};
		System.out.println("Current - radius for Sphere: " + radius.get());
		System.out.println("Current - volume for Sphere: " + volumeOfSphere.get());
		System.out.println("Modifying DoubleProperty radius");
		radius.set(50);
		System.out.println("After - radius for Sphere: " + radius.get());
		System.out.println("After - volume for Sphere: " + volumeOfSphere.get());
	}
}

