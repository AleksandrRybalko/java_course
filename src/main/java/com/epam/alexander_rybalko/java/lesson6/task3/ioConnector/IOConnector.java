package com.epam.alexander_rybalko.java.lesson6.task3.ioConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOConnector {

	public static void writeObject(File file, Object object) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(object);
		}
	}

	public static Object readObject(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		Object result = null;
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
			result = oin.readObject();
		}
		return result;
	}
}
