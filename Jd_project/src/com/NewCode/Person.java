package com.NewCode;


class MAN{
	String name="alex";
	void setName(String n) {name=n;}
	String getname() {return name;}
}
class Employee extends MAN{
	Integer Employeenumber=101;
	void setEmployeenumber(Integer num) {Employeenumber = num;}
	Integer getEmployeenumber() {return Employeenumber;}
	void Computepay() {System.out.println("This is Employee!Computepay");}
	public static void expenseAllowance() {System.out.println("This is Employee!expenseAllowance");}
}
class Manager extends Employee{
	int Salary=1000000;
	void setSalary(int s) {Salary = s;}
	int getSalary() {return Salary;}
	void Computepay() {System.out.println("This is Manager!Computepay");}
	public static void expenseAllowance() {System.out.println("This is Manager!expenseAllowance");}
}
public class Person{
	public static void main(String args[]){ 
		Employee alex;
		alex = new Manager();
		Manager Morty = new Manager();
		Morty.setName("Morty");
		Morty.setEmployeenumber(102);
		Morty.setSalary(1000000000);
		
		Manager man =new Manager();
		Employee emp1 = (Employee)man;
		alex.expenseAllowance();
		man.expenseAllowance();
		
		System.out.println(alex.getname());
		System.out.println(Morty.getname()+Morty.getSalary());
		
		
	}
}