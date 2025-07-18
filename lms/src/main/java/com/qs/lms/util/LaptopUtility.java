package com.qs.lms.util;

import java.util.Scanner;
import com.qs.lms.model.Laptop;

public class LaptopUtility {
	private static Scanner sc = new Scanner(System.in);

	public static Laptop createLaptop() {
		Laptop l = new Laptop();

		System.out.println("user enter laptop id");
		l.setId(sc.nextInt());

		sc.nextLine();

		System.out.println("user enter laptop brand");
		l.setBrand(sc.nextLine());

		System.out.println("user enter laptop model");
		l.setModel(sc.nextLine());

		System.out.println("user enter laptop price");
		l.setPrice(sc.nextDouble());

		return l;
	}
}
