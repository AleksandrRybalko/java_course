package com.epam.alexander_rybalko.java.lesson8.task3.xmlParser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.alexander_rybalko.java.lesson8.task3.vegetable.Nutritive;
import com.epam.alexander_rybalko.java.lesson8.task3.vegetable.Vegetable;

public class XMLParser {
	public static Vegetable getVegetableByXMLFile(File file, String vegetableName) {
		Vegetable result = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("vegetable");
			for (int id = 0; id < nList.getLength(); id++) {
				Node nNode = nList.item(id);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (eElement.getElementsByTagName("name").item(0).getTextContent().equals(vegetableName)) {
						double kcals = Double
								.parseDouble(eElement.getElementsByTagName("kcals").item(0).getTextContent());
						double proteins = Double
								.parseDouble(eElement.getElementsByTagName("proteins").item(0).getTextContent());
						double fats = Double
								.parseDouble(eElement.getElementsByTagName("fats").item(0).getTextContent());
						double carbohydrates = Double
								.parseDouble(eElement.getElementsByTagName("carbohydrates").item(0).getTextContent());
						String fullNameOfVegetable = "com.epam.alexander_rybalko.java.lesson8.task3.vegetable."
								+ vegetableName;
						Class<?> vegetableClass = Class.forName(fullNameOfVegetable);
						Constructor<?> constructor = vegetableClass.getDeclaredConstructor(Nutritive.class);
						result = (Vegetable) constructor
								.newInstance(new Nutritive(kcals, proteins, fats, carbohydrates));
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
