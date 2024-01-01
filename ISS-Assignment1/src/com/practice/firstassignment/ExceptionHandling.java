package com.practice.firstassignment;

/**
 * @author Shrikant_Bhadgaonkar
 * 6.Exception, Hierarchy of exceptions, Handling exceptions, throw vs throws
 */
public class ExceptionHandling {
//	custom exception
	public class IncorrectNameException extends Exception {
		String name;
		IncorrectNameException(String n){
			name=n;
		}
		String getName() {
			return name;
		}
	}
//	Auxiliary pin verification method
	public boolean verifyPin(int[] pin) throws ArrayIndexOutOfBoundsException{
		for(int i=1;i<5;i++) {
			if(pin[i-1]!=i) {
				System.out.println("PIN invalid");
				return false;
			}
		}
		return true;	
	}
//	Auxiliary name verification method
	public boolean verifyName(String name)throws IncorrectNameException {
		if(name.length()<3 | name.contains("@")| name.contains("$"))throw new IncorrectNameException(name);
		return true;
	}
//	Login method based on name and pin
	public void login(String name,int[] pin) {
		boolean loginStatus=false;
		try {
			boolean nameVerify=verifyName(name);
			boolean pinVerify=verifyPin(pin);
			loginStatus=nameVerify&pinVerify;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Incorrect length of pin array");
		}
		catch(IncorrectNameException e) {
			System.out.println("Name entered ("+e.getName()+") is wrong");
		}
		finally {
			if(loginStatus)System.out.println("Login Successful!");
			else System.out.println("Login Failed:(");
		}
	}
	public static void main(String[] args) {
		ExceptionHandling e= new  ExceptionHandling();
		int[] correctPin= {1,2,3,4};
		int[] wrongPin1= {1,2,3};
		int[] wrongPin2= {3,45,34,34};
		String correctName="Shrikant";
		String wrongName1="Sh";
		String wrongName2="S@hrikant";
		System.out.println("Correct Login--------------");
		e.login(correctName,correctPin);
		System.out.println("Failed Login---------------");
		e.login(correctName,wrongPin2);
		System.out.println("Exception Login------------");
		e.login(wrongName1, wrongPin1);
		
	}

}
