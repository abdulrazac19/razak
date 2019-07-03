package database;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.lang.Throwables.*;
public class Main {
public static void main(String[] args) throws Exception
{
		try {
			String url="jdbc:mysql://localhost:3306/hemanthdb";
			Class.forName(com.mysql.jdbc.Driver);
			Connection conn = DriverManager.getConnection(url,"hemanth","hemanth");
			System.out.println("..............................................Java Data Base Connectivity successful......................................................");
		    } 
		catch(Exception e) 
		{
			System.out.println(e);
		}

		while(1)
		{
			System.out.println("1.Create Table\t 2.Insert\t 3.Read\t 4.Delete\t 5.Exit");
			Scanner obj=new Scanner(System.in);
			int ch=obj.nextInt();
			switch (ch) { 
        				case 1: 
           					create();
           					break; 
       					case 2: 
        					insert();
           					break; 
        				case 3: 
            					get();
            					break; 
        				case 4: 
             					delete();
           					break; 
        				case 5: 
            					return;
        				default:
       						System.out.println("invalid choice");
          					break;
				      }
		}
}

public static void delete()
{
		try {
			Connection con = getConnection();
			PreparedStatement delete =con.prepareStatement("delete from tablename1 where first='H'");
			delete.executeUpdate();
		     }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {System.out.println("deleted successfully");}
}

public static void get()
{
		try {
			Connection con = getConnection();
			PreparedStatement get =con.prepareStatement("select * from htable");
			ResultSet result =get.executeQuery();
			while(result.next()) 
			{
				System.out.print(result.getString("first")+" "+result.getString("last")+" "+result.getString("email"));
			}
		    }
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally {System.out.println("read data successfully");}
}


public static void insert()
{
		try {
			Connection con = getConnection();
			final String firstname="hemanth";
			final String lastname="reddy";
			final String email="hr@ojas-it.com";
			PreparedStatement insert =con.prepareStatement("insert into  hname(first,last,email) VALUES('"+firstname+"','"+lastname+"','"+email+"')");
			insert.executeUpdate();
		     }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {System.out.println("inserted successfully");}
}

public static void create()
{
		try {
			Connection con = getConnection();
			PreparedStatement create =con.prepareStatement("CREATE TABLE hname(id int NOT NULL,first varchar(10),last varchar(10),email varchar(20))");
			create.executeUpdate();
		    }
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {System.out.println("created successfully");}
}
