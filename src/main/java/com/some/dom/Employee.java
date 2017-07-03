/* 
 * Assignment: Some Dom		                 *
 * Programmer: Baran Topal                   *
 * File name: Employee.java                  *
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

public class Employee {

	public String name;
	public int id;
	public int age;
	public String type;

	public Employee(String name, int id, int age, String type)
	{
		this.name = name;
		this.id = id;
		this.age = age;
		this.type = type;
	}

	public String toString()
	{
		return "Name: " + name + " Id: " + id + " Age: " + age + " Type: " + type + "\n";
	}
}

