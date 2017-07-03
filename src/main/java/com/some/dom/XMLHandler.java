/* 
 * Assignment: Some Sax		                 *
 * Programmer: Baran Topal                   *
 * File name: XMLHandler.java                *
 *                                           *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  
 */


package com.some.dom;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLHandler {

	public ArrayList al = new ArrayList();

	public void parseXMLFile()
	{
		try{
			//source
			InputStream is = new FileInputStream("src/main/resources/my.xml");

			//get the factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(is);

			NodeList nodeList = doc.getElementsByTagName("Employee");

			if(nodeList != null && nodeList.getLength() > 0)
			{

				for(int i = 0; i < nodeList.getLength(); i++)
				{
					Element element = (Element)nodeList.item(i);

					Employee employee = getEmployee(element);

					al.add(employee);					
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public Employee getEmployee(Element element)
	{
		String name = getTextValue(element, "Name");
		int id = getIntValue(element, "Id");
		int age = getIntValue(element, "Age");

		String type = element.getAttribute("type");

		Employee employee = new Employee(name, id, age, type);

		return employee;		
	}

	public String getTextValue(Element element, String tagName)
	{
		String textValue = null;

		NodeList nodeList = element.getElementsByTagName(tagName);
		if(nodeList != null && nodeList.getLength() > 0)
		{

			Element el = (Element)nodeList.item(0);
			textValue = el.getFirstChild().getNodeValue();
		}
		return textValue;
	}

	public int getIntValue(Element element, String tagName)
	{		
		return Integer.parseInt(getTextValue(element, tagName));
	}

	public void printData()
	{
		System.out.println("Number of employees: " + al.size());
		Iterator iterator = al.iterator();
		while(iterator.hasNext())
		{
			System.out.println((Employee)iterator.next());		
		}
	}
}
