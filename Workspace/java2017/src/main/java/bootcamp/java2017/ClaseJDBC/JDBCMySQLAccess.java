package bootcamp.java2017.ClaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class JDBCMySQLAccess {
	private Connection connect;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public void printCoursesOfTeacher(String teacherFirstName, String teacherLastName) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost::3306/high-school" + "user=root&password=root");

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect
					.prepareStatement("SELECT t.last_name, t.first_name, sch.day_of_the_week, sch.start_time, sch.finish_time, c.course_name "
							+ " FROM course AS c " + " INNER JOIN teacher AS t ON c.teacher_id = t.teacher_id"
							+ " INNER JOIN schedule AS sch ON c.course_id = sch.course_id" + " WHERE t.first_name = ?"
							+ " AND t.last_name = ?" + " ORDER BY sch.day_of_the_week");
			preparedStatement.setString(1, teacherFirstName);
			preparedStatement.setString(2, teacherLastName);
			resultSet = preparedStatement.executeQuery();
			printResultSet(resultSet);

		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			close();
		}

	}

	private void printResultSet(ResultSet resultSet) throws SQLException {
		
		String teacherLastName = "";
		String teacherFirstName = "";
		String day;
		Time startTime;
		Time finishTime;
		String courseName;
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
		}
		if(resultSet.first()){
			teacherLastName = resultSet.getString("last_name");
			teacherFirstName = resultSet.getString("first_name");
		}
		System.out.println("Teacher: " + teacherLastName + ", " + teacherFirstName);
		System.out.println("Schedule: ");
		resultSet.beforeFirst();
		while(resultSet.next()){
			day = resultSet.getString("day_of_the_week");
			startTime = resultSet.getTime("start_time");
			finishTime = resultSet.getTime("finish_time");
			courseName = resultSet.getString("course_name");
			
			System.out.println(day + " " + startTime + " - " + finishTime + ": " + courseName);
			
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}