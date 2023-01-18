package test;

import classes.NewNote;
import panels.*;
import java.sql.*;
import javax.swing.*;
import java.sql.Date;

public class DBController {
    private Connection conn;

    // Construtor que faz a conexão com o banco de dados, você passa
    // o nome do arquivo como parâmetro e ele a realiza.
    public DBController(String dbFile) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para adicionar notas ao banco de dados
    public void addNote(NewNote note) {
        // A string sql é um argumento passado para o gerenciador de banco de dados
        // para que ele saiba onde inserir os dados no banco.
        String sql = "INSERT INTO lists (title, description, dateCreated, reminderDate, priority) VALUES (?, ?, ?, ?, ?)";

        try {
            // PreparedStatement faz uma preparação para a inserção dos dados
            // no banco, ele define em quais colunas os dados serão inseridos.
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (!note.getTitle().equals("Título")) {
                pstmt.setString(1, note.getTitle());
            }
            if (!note.getDescription().equals("Descrição")) {
                pstmt.setString(2, note.getDescription());
            }

            pstmt.setDate(3, note.getDateCreated());

            if (note.getReminderDate() != null) {
                Date sqlDate = new Date(note.getReminderDate().getTime());
                pstmt.setDate(4, sqlDate);
            }
            if (!note.getPriority().equals("Prioridade")) {
                pstmt.setString(5, note.getPriority());
            }
            // Apos a preparação, o método executeUpdate() executa a inserção no banco.
            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para pesquisar notas no banco de dados.
    public ResultSet searchNotes(String query) {
        // Nessa string sql, eu quero selecionar todas as colunas da tabela lists
        // onde o título ou a descrição contenham a string passada no construtor.
        String sql = "SELECT * FROM lists WHERE title LIKE ? OR description LIKE ?";
        // ResultSet cria um objeto que salvas as linhas onde os dados pesquisado se
        // encontram
        ResultSet rs = null;
        try {
            // Nesse PreparedStatement eu passos os atributos onde quero pesquisar no banco.
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // As % servem para fazer buscas parciais, ou seja,
            // vai retornar todas as notas que possuam a palavra pesquisada.

            pstmt.setString(1, "%" + query + "%");
            pstmt.setString(2, "%" + query + "%");

            // Aqui executamos uma pesquisa no banco usando o "pstmt" e salvamos
            // o resultado na variável "rs".
            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }

    // Método para carregar as notas do banco de dados
    public void retrieveAndAddAllNotes(JPanel allNotesPanel) {
        // Create a new ResultSet object
        ResultSet rs = null;

        try {
            // Create a new statement
            Statement statement = conn.createStatement();
            // Execute the SELECT query to retrieve all records from the lists table
            rs = statement.executeQuery("SELECT * FROM lists");

            // Iterate through the ResultSet object
            while (rs.next()) {
                // Create a new instance of the NotesBlock class
                NotesBlock notesBlock = new NotesBlock();

                // Set the text of the JLabel and JTextField components with the note data from
                // the ResultSet
                notesBlock.notesBlockTitle.setText(rs.getString("title"));
                notesBlock.noteBlockDescription.setText(rs.getString("description"));
                notesBlock.notesBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                notesBlock.notesBlockPriority.setText("Prioridade: " + rs.getString("priority"));

                // Add the NotesBlock to the notesPanel
                allNotesPanel.add(notesBlock);
            }

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
