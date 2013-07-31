/**
 * @author Shoucong Chen
 * July 22, 2013
 */

package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import random.Randomization;

public class RandomizationDAO {
	public String path;
	
	public RandomizationDAO(String path) {
		this.path = path;
	}
	
	public Randomization readRandomization() {
		Randomization r;
		try {
			FileInputStream fileIn = new FileInputStream(path + "random.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			r = (Randomization) in.readObject();
			in.close();
			fileIn.close();
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException c) {
			System.out.println("Randomization class not found");
			c.printStackTrace();
			return null;
		}
		
		return r;
	}
	
	public boolean writeRandomization(Randomization r) {
		try {
			FileOutputStream fileOut = new FileOutputStream(path + "random.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(r);
			out.close();
			fileOut.close();
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
