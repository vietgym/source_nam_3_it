package main;

import java.sql.Connection;
import java.util.List;

import entity.Fruit;

public class main {

	public static void main(String[] args) {
//      Connection myConn = jdbc.getConnection();
//      if (myConn != null) {
//          System.out.println("Connection successful!");
//      } else {
//          System.out.println("Connection failed!");
//      }
//		creat.insertFruit("Qua oi thoc");
		List<Fruit> fruits = getall.getAllFruits();

        // Hiển thị thông tin về tất cả các quả trái
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
	}

}
