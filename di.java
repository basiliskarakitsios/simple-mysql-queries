import java.sql.*;
import java.util.Scanner;

class di
{
	public static void main(String ... args)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the path to the database (ours was \"jdbc:mysql://localhost:3306/school\"): ");
			String dbUrl = input.nextLine();
			System.out.println("Enter username (i.e. \"root\"): ");
			String username = input.nextLine();
			System.out.println("Enter password: ");
			String password = input.nextLine();
			Connection myConnection = DriverManager.getConnection(dbUrl, username, password);
			Statement myStatement = myConnection.createStatement();
			System.out.println("Enter table name: ");
			String tableName = input.nextLine();
			System.out.println("Enter column name: ");
			String columnName = input.nextLine();
			System.out.println("Enter value: ");
			String value = input.nextLine();
			System.out.println("SELECT * FROM " + tableName + " WHERE " + columnName + " = " + value + ";");
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM " + tableName + " WHERE " + columnName + " = " + "\"" +  value + "\"" + ";");
			if(tableName.equals("advisedby"))
			{
				System.out.println("s_id	p_id");
			}else if(tableName.equals("course"))
			{
				System.out.println("course_id	courseLevel");
			}else if(tableName.equals("professor"))
			{
				System.out.println("p_id	hasPosition");
			}else if(tableName.equals("student"))
			{
				System.out.println("s_id	inPhase	yearsinProgram");
			}else if(tableName.equals("taughtby"))
			{
				System.out.println("course_id	u_id");
			}while(myResultSet.next())
			{
				if(tableName.equals("advisedby"))
				{
					System.out.println(myResultSet.getString("s_id") + "	" + myResultSet.getString("p_id"));
				}else if(tableName.equals("course"))
				{
					System.out.println(myResultSet.getString("course_id") + "	" + myResultSet.getString("courseLevel"));
				}else if(tableName.equals("professor"))
				{
					System.out.println(myResultSet.getString("p_id") + "	" + myResultSet.getString("hasPosition"));
				}else if(tableName.equals("student"))
				{
					System.out.println(myResultSet.getString("s_id") + "	" + myResultSet.getString("inPhase") + "	" + myResultSet.getString("yearsinProgram"));
				}else if(tableName.equals("taughtby"))
				{
					System.out.println(myResultSet.getString("course_id") + "	" + myResultSet.getString("u_id"));
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
