import java.sql.*;
import java.util.Scanner;

class dii
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
			ResultSet myResultSet = myStatement.executeQuery("(select taughtby.course_id as courses, professor.p_id as u_id, professor.hasPosition as pos from professor inner join taughtby on professor.p_id = taughtby.u_id) UNION (select taughtby.course_id as courses, student.s_id as u_id, student.inPhase as pos from student inner join taughtby on student.s_id = taughtby.u_id) order by courses asc");
			System.out.println("course_id	id		pos\n");
			while(myResultSet.next())
			{
				String pos = myResultSet.getString("pos");
				if(pos.equals("Faculty") || pos.equals("Faculty_eme") || pos.equals("Faculty_aff") || pos.equals("Faculty_adj"))
				{
					pos = pos.replace(pos, "prof");
				}else if(pos.equals("Post_Generals") || pos.equals("Pre_Quals") || pos.equals("Post_Quals"))
				{
					pos = pos.replace(pos, "stud");				
				}
				System.out.println(myResultSet.getString("courses") + "		" + myResultSet.getString("u_id") + "		" + pos);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
