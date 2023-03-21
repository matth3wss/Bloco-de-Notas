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
            } else {
                pstmt.setString(5, null);
            }
            // Apos a preparação, o método executeUpdate() executa a inserção no banco.
            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void retrieveAndSetNote(int id, Home home) {
        String sql = "SELECT * FROM notes WHERE id = ?";
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {

                if (rs.getString("title") != null) {
                    home.noteTitle.setText(rs.getString("title"));
                } else {
                    home.noteTitle.setText("Título");
                }

                if (rs.getString("description") != null) {
                    home.noteDescription.setText(rs.getString("description"));
                } else {
                    home.noteDescription.setText("Descrição");
                }

                home.noteId.setText(String.valueOf(rs.getInt("id")));

                if (rs.getString("priority") != null) {
                    home.notePriority.setSelectedItem(rs.getString("priority"));
                } else {
                    home.notePriority.setSelectedItem("Prioridade");
                }

                home.noteReminderDate.setDate(rs.getDate("reminderDate"));
            } else {
                JOptionPane.showMessageDialog(null, "Note not found!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    // Método para carregar as notas do banco de dados e colocar na GUI.
    public void retrieveAndAddAllNotes(JPanel allNotesPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home) throws Exception {
        retrieveAndAddAllNotes(allNotesPanel, gridBagLayout, gridBagConstraints, home, "");
    }

    public void retrieveAndAddAllNotes(JPanel allNotesPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home, String searchTerm) throws Exception {
        ResultSet rs = null;
        String query = "";
        if (searchTerm == null || searchTerm.equals("")) {
            query = "SELECT * FROM notes";
        } else {
            query = "SELECT * FROM notes WHERE title LIKE ? OR description LIKE ?";
        }
        try {
            if (query.equals("SELECT * FROM notes")) {
                PreparedStatement pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
            } else {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + searchTerm + "%");
                pstmt.setString(2, "%" + searchTerm + "%");
                rs = pstmt.executeQuery();
            }
            while (rs.next()) {
                NotesBlock notesBlock = new NotesBlock(home);
                notesBlock.notesBlockId.setText("" + rs.getInt("id"));
                notesBlock.notesBlockTitle.setText(rs.getString("title"));
                notesBlock.noteBlockDescription.setText(rs.getString("description"));
                if (rs.getDate("reminderDate") != null) {
                    notesBlock.notesBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                } else {
                    notesBlock.notesBlockReminderDateLabel.setText("");
                }
                if (rs.getString("priority") != null) {
                    notesBlock.notesBlockPriority.setText("Prioridade: " + rs.getString("priority"));
                } else {
                    notesBlock.notesBlockPriority.setText("");
                }
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
    // Method to load reminders from the database and display in the GUI
    public void retrieveAndAddAllReminders(JPanel allRemindersPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home) throws Exception {
        retrieveAndAddAllReminders(allRemindersPanel, gridBagLayout, gridBagConstraints, home, "");
    }

    public void retrieveAndAddAllReminders(JPanel allRemindersPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home, String searchTerm) throws Exception {
        ResultSet rs = null;
        String query = "";
        if (searchTerm == null || searchTerm.equals("")) {
            query = "SELECT * FROM notes WHERE reminderDate IS NOT NULL";
        } else {
            query = "SELECT * FROM notes WHERE (title LIKE ? OR description LIKE ?) AND reminderDate IS NOT NULL";
        }
        try {
            if (query.equals("SELECT * FROM notes WHERE reminderDate IS NOT NULL")) {
                PreparedStatement pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
            } else {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + searchTerm + "%");
                pstmt.setString(2, "%" + searchTerm + "%");
                rs = pstmt.executeQuery();
            }

            while (rs.next()) {
                RemindersBlock remindersBlock = new RemindersBlock(home);
                remindersBlock.remindersBlockTitle.setText(rs.getString("title"));
                remindersBlock.remindersBlockDescription.setText(rs.getString("description"));
                remindersBlock.remindersBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                if (rs.getString("priority") != null) {
                    remindersBlock.remindersBlockPriority.setText("Priority: " + rs.getString("priority"));
                } else {
                    remindersBlock.remindersBlockPriority.setText("");
                }
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

    public void updateNotes(int id, NewNote updateNote) {
        String sql = "UPDATE notes SET title = ?, description = ?, priority = ?, reminderDate = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            if (!updateNote.getTitle().equals("Título")) {
                pstmt.setString(1, updateNote.getTitle());
            }
            if (!updateNote.getDescription().equals("Descrição")) {
                pstmt.setString(2, updateNote.getDescription());
            }
            if (!updateNote.getPriority().equals("Prioridade")) {
                pstmt.setString(3, updateNote.getPriority());
            }

            if (updateNote.getReminderDate() != null) {
                Date sqlDate = new Date(updateNote.getReminderDate().getTime());
                pstmt.setDate(4, sqlDate);
            }
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void repaintNotes(Home home) {
        repaintNotes(home, null);
    }

    public void repaintNotes(Home home, String searchText) {
        home.contentNotesPage.allNotesPanel.setLayout(home.gridBagLayout);
        try {
            home.contentNotesPage.allNotesPanel.removeAll();
            retrieveAndAddAllNotes(home.contentNotesPage.allNotesPanel, home.gridBagLayout, home.gridBagConstraints,
                    home, searchText);
            for (Component c : home.contentNotesPage.allNotesPanel.getComponents()) {
                home.gridBagLayout.setConstraints(c, home.gridBagConstraints);
                home.gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void repaintReminders(Home home) {
        repaintReminders(home, null);
    }

    public void repaintReminders(Home home, String searchText) {
        home.contentRemindersPage.allRemindersPanel.setLayout(home.gridBagLayout);
        try {
            home.contentRemindersPage.allRemindersPanel.removeAll();
            retrieveAndAddAllReminders(home.contentRemindersPage.allRemindersPanel, home.gridBagLayout,
                    home.gridBagConstraints, home, searchText);
            for (Component c : home.contentRemindersPage.allRemindersPanel.getComponents()) {
                home.gridBagLayout.setConstraints(c, home.gridBagConstraints);
                home.gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
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