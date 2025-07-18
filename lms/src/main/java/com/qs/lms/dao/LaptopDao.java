package com.qs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qs.lms.model.Laptop;

public class LaptopDao {
	private static String url = "jdbc:postgresql://localhost:5432/Shop?user=postgres&password=Ayan@1234";
	private static Scanner sc = new Scanner(System.in);
	private static Connection c = null;

	static {
		try {
			c = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method which is containing logic to save the laptop data
	public static void saveLaptop(Laptop l) {
		try {
			PreparedStatement ps = c.prepareStatement("insert into laptop values(?,?,?,?)");
			ps.setInt(1, l.getId());
			ps.setString(2, l.getBrand());
			ps.setDouble(3, l.getPrice());
			ps.setString(4, l.getModel());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Fine by id
	public static Laptop findLaptopById(int id) throws SQLException {
		String query = "select * from laptop where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Laptop l = new Laptop();
			l.setId(rs.getInt(1));
			l.setBrand(rs.getString(2));
			l.setPrice(rs.getDouble(3));
			l.setModel(rs.getString(4));

			return l;
		}
		return null;
	}

	// Delete
	public static boolean deleteById(int id) throws SQLException {
		if (findLaptopById(id) == null) {
			System.out.println("User enter valid laptop id");
			return false;
		}
		String query = "delete from laptop where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}

	// Findall
	public static void findAll() throws SQLException {
		String query = "select * from laptop";
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			System.out.println("Laptop [ id is " + rs.getInt(1) + ",brand is" + rs.getString(2) + ",price is"
					+ rs.getDouble(3) + ",model is" + rs.getString(4) + "j");
		}
	}

	// Update
	public static void updateLaptopPrice(int id) throws SQLException {
		if (findLaptopById(id) == null) {
			System.out.println("User enter valid id");
			return;
		}
		String query = "update laptop set price=? where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		System.out.println("User enter new price");
		ps.setDouble(1, sc.nextDouble());
		ps.setInt(2, id);
		ps.execute();
	}

	// Close the connection
	public static void closeConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
