package org.itstep.model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.controller.InputNoteNoteBook;

public class NoteBookDAO {

	public NoteBook  getUser(InputNoteNoteBook inputNoteBook) {
		NoteBook noteBook = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionDB.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM note_book WHERE login_data=?");
			preparedStatement.setString(1, inputNoteBook.getLoginData());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String loginData = resultSet.getString("login_data");
				try {
					noteBook = new NoteBook(firstName, loginData);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return noteBook;
	}
}
