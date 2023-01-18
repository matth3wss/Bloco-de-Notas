package classes;

import panels.*;
import java.sql.Date;
import java.sql.*;
import javax.swing.*;

import java.awt.*;
import main.Home;

public class DBController implements Searchable {
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
        String sql = "INSERT INTO notes (title, description, dateCreated, reminderDate, priority) VALUES (?, ?, ?, ?, ?)";

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

    @Override
    // Método para pesquisar notas no banco de dados.
    public ResultSet searchNotes(String query) {
        // Nessa string sql, eu quero selecionar todas as colunas da tabela notes
        // onde o título ou a descrição contenham a string passada no construtor.
        String sql = "SELECT * FROM notes WHERE title LIKE ? OR description LIKE ?";
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

    @Override
    // Método para pesquisar lembretes no banco de dados.
    public ResultSet searchReminders(String query) {
        // Nessa string sql, eu quero selecionar todas as colunas da tabela notes
        // onde o título ou a descrição contenham a string passada no construtor.
        String sql = "SELECT * FROM notes WHERE title LIKE ? OR description LIKE ?";
        // ResultSet cria um objeto que salvas as linhas onde os dados pesquisado se
        // encontram
        ResultSet rs = null;
        try {
            // Nesse PreparedStatement eu passos os atributos onde quero pesquisar no banco.
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // As % servem para fazer buscas parciais, ou seja,
            // vai retornar todas as notas que possuam a palavra pesquisada.
            pstmt.setString(1, "%" + query + "%");

            // Aqui executamos uma pesquisa no banco usando o "pstmt" e salvamos
            // o resultado na variável "rs".
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
@Override
    // Método para carregar as notas do banco de dados e colocar na GUI.
    public void retrieveAndAddAllNotes(JPanel allNotesPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home) throws Exception {
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM notes");
            while (rs.next()) {
                NotesBlock notesBlock = new NotesBlock(home);
                notesBlock.notesBlockId.setText("" + rs.getInt("id"));

                notesBlock.notesBlockTitle.setText(rs.getString("title"));
                notesBlock.noteBlockDescription.setText(rs.getString("description"));
                if (rs.getDate("reminderDate") != null) {
                    notesBlock.notesBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                }
                notesBlock.notesBlockPriority.setText("Prioridade: " + rs.getString("priority"));
                gridBagLayout.setConstraints(notesBlock, gridBagConstraints);

                allNotesPanel.add(notesBlock, gridBagConstraints);
                gridBagConstraints.gridx++;
                if (gridBagConstraints.gridx == 5) {
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy++;
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void retrieveAndAddAllNotes2(JPanel allNotesPanel, GridBagLayout gridBagLayout, 
            GridBagConstraints gridBagConstraints, String searchTerm, Home home) throws Exception {
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM notes WHERE title LIKE ? OR description LIKE ?");
            pstmt.setString(1, "%" + searchTerm + "%");
            pstmt.setString(2, "%" + searchTerm + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                NotesBlock notesBlock = new NotesBlock(home);
                notesBlock.notesBlockId.setText("" + rs.getInt("id"));
                notesBlock.notesBlockTitle.setText(rs.getString("title"));
                notesBlock.noteBlockDescription.setText(rs.getString("description"));
                if (rs.getDate("reminderDate") != null) {
                    notesBlock.notesBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                }
                notesBlock.notesBlockPriority.setText("Prioridade: " + rs.getString("priority"));
                gridBagLayout.setConstraints(notesBlock, gridBagConstraints);

                allNotesPanel.add(notesBlock, gridBagConstraints);
                gridBagConstraints.gridx++;
                if (gridBagConstraints.gridx == 5) {
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy++;
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    // Método para carregar os lembretes do banco de dados e colocar na GUI.
    public void retrieveAndAddAllReminders(JPanel allRemindersPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints) throws Exception {

        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            // Nesse PreparedStatement eu passos os atributos onde quero pesquisar no banco.
            rs = statement.executeQuery("SELECT * FROM notes WHERE reminderDate IS NOT NULL");

            // Percorre o objeto ResultSet pegando cada linha do banco de dados.
            while (rs.next()) {
                // Criamos um novo frame do tipo RemindersBlock, para adicionar-mos na GUI.
                RemindersBlock remindersBlock = new RemindersBlock();

                // Set the text of the JLabel and JTextField components with the note data from
                // the ResultSet
                remindersBlock.remindersBlockTitle.setText(rs.getString("title"));
                remindersBlock.remindersBlockDescription.setText(rs.getString("description"));
                remindersBlock.remindersBlockDateLabel.setText(rs.getDate("reminderDate").toString());
                remindersBlock.remindersBlockPriority.setText("Prioridade: " + rs.getString("priority"));

                gridBagLayout.setConstraints(remindersBlock, gridBagConstraints);
                allRemindersPanel.add(remindersBlock, gridBagConstraints);
                gridBagConstraints.gridx++;
                if (gridBagConstraints.gridx == 5) {
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy++;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateNotes(int id, String newTitle, String newDescription, String newPriority, java.sql.Date newReminderDate) {
        String sql = "UPDATE notes SET title = ?, description = ?, priority = ?, reminderDate = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newDescription);
            pstmt.setString(3, newPriority);
            Date sqlDate = new Date(newReminderDate.getTime());
            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
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