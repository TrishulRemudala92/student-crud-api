package org.geeksforgeeks.crash_course_spring;

import java.util.Scanner;

public class TrishulClass {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		addTwoNumbers(a,b);
		}

	public static void addTwoNumbers(int a, int b) {
		int sum=a+b;
		System.out.println("sum:"+sum);
	}
}

