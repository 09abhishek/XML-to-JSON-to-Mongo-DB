package com.abhi.XMLtomySQL;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertXML {
	
	public void insert(File xmlFile) throws ClassNotFoundException 
	{
		try {
			String url = "jdbc:mysql://localhost/mydb";
			String username = "root";
			String password = "root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			
			final String INSERT_SQL =  "insert into xmldump(FILENAME, MIMETYPE, CONTENT) values(?, ?, ?)";

			PreparedStatement ps  = con.prepareStatement(INSERT_SQL);
			ps.setString(1, xmlFile.getName());
			ps.setString(2, getMimeType(xmlFile));
			ps.setBinaryStream(3, new FileInputStream(xmlFile));
			ps.executeUpdate();
		} catch (SQLException e) {
			// CLOSE ps and con;
		} catch (FileNotFoundException e) {
			// CLOSE ps and con;
		} finally {
			// CLOSE ps and con;
		}
	}

	public String getMimeType(File xmlFile) {
		String mimeType = null;
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(xmlFile));
			mimeType = URLConnection.guessContentTypeFromStream(is);
			System.out.println("I am executing!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mimeType;
	}

	public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
		InsertXML insertXML = new InsertXML();
		insertXML.insert(new File("D:\\ExternalFileLink\\product.xml"));
	}
}
