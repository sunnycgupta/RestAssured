package restWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Rectangle implements Serializable{
	
	private double length;
	private double breadth;
	
	public Rectangle(double length,double breadth) {
		this.length=length;
		this.breadth=breadth;
		
	}
	public double area() {
		return (length*breadth);
	}
	
	public double perimeter() {
		return (2*(length+breadth));
	}
	
	public static void serializeObjectToFile(Object classObject, String filename) {
		try {
		FileOutputStream fileOutputStream=new FileOutputStream(new File(filename));
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(classObject);
		objectOutputStream.close();
		fileOutputStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Object deserializeFileToObject(String fileName)   {
		try {
		FileInputStream fileInputStream=new FileInputStream(new File(fileName));
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		Object reSerializeObject=objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		return reSerializeObject;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return  null;
		
	}
}
