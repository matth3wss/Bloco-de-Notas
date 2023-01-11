package classes;

import classes.Task;
import java.sql.*;
import javax.swing.*;
import java.sql.Date;

public class DBController {
    private Connection conn;

    public DBController(String dbFile) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void addNote(Task task) {
        String sql = "INSERT INTO lists (title, description, date, priority) VALUES (?, ?, ?, ?)";

        try {
            Date sqlDate = new Date(task.getDateCreated().getTime());
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setDate(3, sqlDate);
            pstmt.setInt(4, task.getPriority());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void searchNote(String query) {
        String sql = "SELECT * FROM lists WHERE title LIKE ? OR description LIKE ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
