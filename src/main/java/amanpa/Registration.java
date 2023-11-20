package amanpa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		    String email = request.getParameter("email");
		    String password = request.getParameter("pass");
		    String mob = request.getParameter("mob");
		 if(name!=null) {
		    try{
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regis","root","root");
		    	
		    	String sql = "insert into student values(?,?,?,?)";
		    	PreparedStatement ps = con.prepareStatement(sql);
		    	
		    	ps.setString(1,name);
		    	ps.setString(2, email);
		    	ps.setString(3, password);
		    	ps.setString(4,mob);
		    	
		    	int i =ps.executeUpdate();
		    	if(i>0)
		    		response.sendRedirect("Home.jsp");
		    	else
		    		response.sendRedirect("Registration Failed");
		    }catch(Exception e){
		    	 e.printStackTrace();
		    }
	}
	}
}
