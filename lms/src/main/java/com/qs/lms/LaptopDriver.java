package com.qs.lms;

import java.sql.SQLException;
import java.util.Scanner;

import com.qs.lms.dao.LaptopDao;
import com.qs.lms.util.LaptopUtility;

public class LaptopDriver {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("user enter \n1 to save \n2 to find laptop by id");
			System.out.println("3 to delete laptop by id \n4 to find all laptops");
			System.out.println("5 to update laptop price \n6 to exit");
//			System.out.println("6 to exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				LaptopDao.saveLaptop(LaptopUtility.createLaptop());
				System.out.println("Successfully inserted laptop record");
				break;
			case 2: {
				System.out.println("user enter id to find laptop");
				System.out.println(LaptopDao.findLaptopById(sc.nextInt()));
			}
				break;
			case 3: {
				LaptopDao.findAll();
				System.out.println("select laptop id to delete laptop");
				LaptopDao.deleteById(sc.nextInt());
				System.out.println("laptop record successfully deleted");
			}
				break;
			case 4:
				LaptopDao.findAll();
				break;
			case 5: {
				LaptopDao.findAll();
				System.out.println("User enter laptop id to update");
				LaptopDao.updateLaptopPrice(sc.nextInt());
			}
				break;
			case 6: {
				System.out.println("successfully exited");
				LaptopDao.closeConnection();
				return;
			}
			default:
				System.out.println("user enter invalid input");
				break;
			}
		}
	}
}
