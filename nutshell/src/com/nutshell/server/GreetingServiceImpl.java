package com.nutshell.server;

import com.nutshell.client.GreetingService;
import com.nutshell.shared.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "mysql");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String login(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs = null;
		String ss = "No";
		try {
			rs = stmt.executeQuery("select * from register where email_id= '" + s1 + "' and password= '" + s2 + "' ");
			while (rs.next()) {
				ss = "Yes";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return ss;
	}

	@Override
	public String sign(details r) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			pstmt = con.prepareStatement("insert into register values(?,?,?,?,?)");
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getEmail_id());
			pstmt.setString(3, r.getNews_agency());
			pstmt.setInt(4, r.getPhone());
			pstmt.setString(5, r.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return "Yes";
	}

	@Override
	public String publish(data d) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();

		try {

			pstmt = con.prepareStatement("insert into longdata values(?,?,?,?,?)");
			pstmt.setString(1, d.getImage());
			pstmt.setString(2, d.getHeadline());
			pstmt.setString(3, d.getTag());
			pstmt.setString(4, d.getSummary());
			pstmt.setString(5, d.getCategory());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Yes";
	}

	@Override
	public data addheadline(String h) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		data d = new data();
		init();
		try {
			rs = stmt.executeQuery("select * from longdata where headline= '" + h + "' ");

			while (rs.next()) {
				d.setImage(rs.getString(1));
				d.setHeadline(rs.getString(2));
				d.setTag(rs.getString(3));
				d.setSummary(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return d;
	}

	@Override
	public heading fheadline(String h) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs = null;
		int i = 0;

		try {

			rs = stmt.executeQuery("select * from longdata where category= '" + h + "' ");
			rs.last();
			int n = rs.getRow();
			rs.beforeFirst();
			String data[] = new String[n];
			heading hi = new heading();
			hi.setN(n);
			// System.out.println(n+"\n");
			while (rs.next()) {
				data[i] = rs.getString(2);
				// System.out.println(data[i]);
				i++;
			}
			hi.setA(data);
			return hi;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;

	}

	@Override
	public String finalsummary(data d) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();

		try {

			pstmt = con.prepareStatement("insert into fsummary values(?,?)");
			
			pstmt.setString(1, d.getSummary());
			pstmt.setString(2, d.getHeadline());			

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Yes";

	}
}
