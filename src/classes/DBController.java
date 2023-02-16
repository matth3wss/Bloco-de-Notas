package classes;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import main.Home;
import panels.*;

public class DBController implements Searchable {
    private Connection conn;

    /**
     * Construtor que faz a conexão com o banco de dados.
     * Recebe o nome do arquivo do banco como parâmetro e realiza a conexão.
     * 
     * @param dbFile
     */
    public DBController(String dbFile) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (SQLException e) {
            // Exibe mensagem de erro caso a conexão com o banco falhe
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            // Exibe mensagem de erro caso o driver do JDBC não seja encontrado
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Método para adicionar uma nova nota ao banco de dados.
     * Recebe como parâmetro uma nota do tipo NewNote.
     * 
     * @param note
     */
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
            // Exibe mensagem de erro caso a operação de inserção falhe
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Método para recuperar e definir a nota a partir do banco de dados
     * Recebe como parâmetro o ID da nota e a GUI Home
     * 
     * @param id
     * @param home
     */
    public void retrieveAndSetNote(int id, Home home) {
        // Cria a string de consulta SQL
        String sql = "SELECT * FROM notes WHERE id = ?";
        // ResultSet para armazenar o resultado da consulta
        ResultSet rs = null;
        // PreparedStatement para executar a consulta
        PreparedStatement pstmt = null;
        try {
            // Prepara a consulta com o ID passado como parâmetro
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            // Executa a consulta
            rs = pstmt.executeQuery();
            // Verifica se houve resultados
            if (rs.next()) {
                // Se houver um título na consulta, define-o na GUI
                if (rs.getString("title") != null) {
                    home.noteTitle.setText(rs.getString("title"));
                } else {
                    // Caso contrário, define um título padrão
                    home.noteTitle.setText("Título");
                }
                // Da mesma forma para a descrição
                if (rs.getString("description") != null) {
                    home.noteDescription.setText(rs.getString("description"));
                } else {
                    home.noteDescription.setText("Descrição");
                }
                // Define o ID na GUI
                home.noteId.setText(String.valueOf(rs.getInt("id")));
                // Verifica se há uma prioridade na consulta
                if (rs.getString("priority") != null) {
                    // Se houver, define-a na GUI
                    home.notePriority.setSelectedItem(rs.getString("priority"));
                } else {
                    // Caso contrário, define uma prioridade padrão
                    home.notePriority.setSelectedItem("Prioridade");
                }
                // Define a data de lembrete na GUI
                home.noteReminderDate.setDate(rs.getDate("reminderDate"));
            } else {
                // Caso não haja resultados, exibe uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Note not found!");
            }
        } catch (SQLException e) {
            // Caso haja uma exceção de SQL, exibe a mensagem de erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    /**
     * Método para carregar as notas do banco de dados e colocar na GUI.
     * O parâmetro de pesquisa permite filtrar as notas com base em um termo de
     * pesquisa.
     * 
     * @param allNotesPanel
     * @param gridBagLayout
     * @param gridBagConstraints
     * @param home
     * @param searchTerm
     * @throws Exception
     */
    public void retrieveAndAddAllNotes(JPanel allNotesPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home) throws Exception {
        retrieveAndAddAllNotes(allNotesPanel, gridBagLayout, gridBagConstraints, home, "");
    }

    /**
     * Método para recuperar e adicionar todas as notas do banco de dados e
     * colocá-las na GUI.
     * O parâmetro de pesquisa permite filtrar as notas com base em um termo de
     * pesquisa.
     * 
     * @param allNotesPanel
     * @param gridBagLayout
     * @param gridBagConstraints
     * @param home
     * @param searchTerm
     * @throws Exception
     */
    public void retrieveAndAddAllNotes(JPanel allNotesPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home, String searchTerm) throws Exception {
        ResultSet rs = null;
        String query = "";
        // Verifica se o termo de pesquisa é nulo ou vazio e cria a consulta SQL
        // apropriada.
        if (searchTerm == null || searchTerm.equals("")) {
            query = "SELECT * FROM notes";
        } else {
            query = "SELECT * FROM notes WHERE title LIKE ? OR description LIKE ?";
        }
        try {
            // Prepara a declaração SQL com base na consulta criada anteriormente.
            if (query.equals("SELECT * FROM notes")) {
                PreparedStatement pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
            } else {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + searchTerm + "%");
                pstmt.setString(2, "%" + searchTerm + "%");
                rs = pstmt.executeQuery();
            }
            // Enquanto houver resultados na consulta SQL, adiciona uma nova "NotesBlock" na
            // GUI.
            while (rs.next()) {
                NotesBlock notesBlock = new NotesBlock(home);
                notesBlock.notesBlockId.setText("" + rs.getInt("id"));
                notesBlock.notesBlockTitle.setText(rs.getString("title"));
                notesBlock.noteBlockDescription.setText(rs.getString("description"));
                // Verifica se a data de lembrete existe e a adiciona na "NotesBlock", caso
                // contrário, deixa vazia.
                if (rs.getDate("reminderDate") != null) {
                    notesBlock.notesBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                } else {
                    notesBlock.notesBlockReminderDateLabel.setText("");
                }

                // Verifica se existe prioridade e a adiciona na "NotesBlock", caso contrário,
                // deixa vazia.
                if (rs.getString("priority") != null) {
                    notesBlock.notesBlockPriority.setText("Prioridade: " + rs.getString("priority"));
                } else {
                    notesBlock.notesBlockPriority.setText("");
                }
                // Define as restrições para a posição da "NotesBlock" no painel de todas as
                // notas.
                gridBagLayout.setConstraints(notesBlock, gridBagConstraints);
                allNotesPanel.add(notesBlock, gridBagConstraints);
                // Incrementa a posição X da "NotesBlock" no painel.
                gridBagConstraints.gridx++;
                // Verifica se a posição X chegou ao final da linha. Se sim, retorna para o
                // início da próxima linha.
                if (gridBagConstraints.gridx == 5) {
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy++;
                }
            }
        } catch (SQLException e) {
            // Exibe uma mensagem de erro caso haja algum problema com a consulta ao banco
            // de dados.
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    /**
     * Método para carregar os lembretes do banco de dados e colocar na GUI.
     * O parâmetro de pesquisa permite filtrar os lembretes com base em um termo de
     * pesquisa.
     * 
     * @param allRemindersPanel
     * @param gridBagLayout
     * @param gridBagConstraints
     * @param home
     * @param searchTerm
     * @throws Exception
     */
    public void retrieveAndAddAllReminders(JPanel allRemindersPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home) throws Exception {
        // Chama o método com um termo de pesquisa vazio
        retrieveAndAddAllReminders(allRemindersPanel, gridBagLayout, gridBagConstraints, home, "");
    }

    public void retrieveAndAddAllReminders(JPanel allRemindersPanel, GridBagLayout gridBagLayout,
            GridBagConstraints gridBagConstraints, Home home, String searchTerm) throws Exception {
        ResultSet rs = null;
        String query = "";
        // Verifica se o termo de pesquisa é nulo ou vazio
        if (searchTerm == null || searchTerm.equals("")) {
            // Se sim, define a consulta como selecionar todas as notas que tenham uma data
            // de lembrete
            query = "SELECT * FROM notes WHERE reminderDate IS NOT NULL";
        } else {
            // Se não, define a consulta como selecionar todas as notas que tenham uma data
            // de lembrete e que correspondam ao termo de pesquisa no título ou descrição
            query = "SELECT * FROM notes WHERE (title LIKE ? OR description LIKE ?) AND reminderDate IS NOT NULL";
        }
        try {
            if (query.equals("SELECT * FROM notes WHERE reminderDate IS NOT NULL")) {
                // Prepara a consulta sem termo de pesquisa
                PreparedStatement pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
            } else {
                // Prepara a consulta com termo de pesquisa
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + searchTerm + "%");
                pstmt.setString(2, "%" + searchTerm + "%");
                rs = pstmt.executeQuery();
            }
            // Enquanto houver resultados na consulta
            while (rs.next()) {
                // Cria um novo objeto "RemindersBlock"
                RemindersBlock remindersBlock = new RemindersBlock(home);
                // Define o título, descrição e data de lembrete na "RemindersBlock" com base
                // nos resultados da consulta
                remindersBlock.remindersBlockId.setText("" + rs.getInt("id"));
                remindersBlock.remindersBlockTitle.setText(rs.getString("title"));
                remindersBlock.remindersBlockDescription.setText(rs.getString("description"));
                remindersBlock.remindersBlockReminderDateLabel.setText(rs.getDate("reminderDate").toString());
                // Verifica se a prioridade existe e a adiciona na "RemindersBlock", caso
                // contrário, deixa vazia.
                if (rs.getString("priority") != null) {
                    remindersBlock.remindersBlockPriority.setText("Priority: " + rs.getString("priority"));
                } else {
                    remindersBlock.remindersBlockPriority.setText("");
                }
                gridBagLayout.setConstraints(remindersBlock, gridBagConstraints);
                allRemindersPanel.add(remindersBlock, gridBagConstraints);
                gridBagConstraints.gridx++;
                // Verifica se a contagem de colunas atingiu 5. Se sim, a próxima coluna
                // começará na primeira linha e a contagem de colunas será reiniciada.
                if (gridBagConstraints.gridx == 5) {
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy++;
                }
            }
        } catch (SQLException e) {
            // Exibe uma mensagem de erro caso ocorra uma exceção SQL
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Este método atualiza as informações de uma nota existente no banco de dados
     * Recebe o ID da nota e o objeto de nota atualizado como argumentos
     * 
     * @param id
     * @param updateNote
     * @throws Exception
     */
    public void updateNotes(int id, NewNote updateNote) throws Exception {
        // SQL para atualizar as informações da nota no banco de dados
        String sql = "UPDATE notes SET title = ?, description = ?, priority = ?, reminderDate = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Verifica se o título da nota foi atualizado
            if (!updateNote.getTitle().equals("Título")) {
                pstmt.setString(1, updateNote.getTitle());
            }
            // Verifica se a descrição da nota foi atualizada
            if (!updateNote.getDescription().equals("Descrição")) {
                pstmt.setString(2, updateNote.getDescription());
            }
            // Verifica se a prioridade da nota foi atualizada
            if (!updateNote.getPriority().equals("Prioridade")) {
                pstmt.setString(3, updateNote.getPriority());
            }

            // Verifica se a data de lembrete foi atualizada
            if (updateNote.getReminderDate() != null) {
                // Converte a data de lembrete do tipo java.util.Date para java.sql.Date
                Date sqlDate = new Date(updateNote.getReminderDate().getTime());
                pstmt.setDate(4, sqlDate);
            }
            // Define o ID da nota para atualizar
            pstmt.setInt(5, id);
            // Executa a atualização
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Exibe uma mensagem de erro caso ocorra uma exceção durante a atualização
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Este método é uma sobrecarga do método repaintNotes(Home home, String
     * searchText)
     * Chama o método repaintNotes com um valor nulo para o parâmetro de pesquisa
     * 
     * @param home
     */
    public void repaintNotes(Home home) {
        repaintNotes(home, null);
    }

    public void repaintNotes(Home home, String searchText) {
        // Define o layout da página de notas como um GridBagLayout
        home.contentNotesPage.allNotesPanel.setLayout(home.gridBagLayout);
        try {
            // Remove todos os componentes da página de notas
            home.contentNotesPage.allNotesPanel.removeAll();
            // Chama o método retrieveAndAddAllNotes para adicionar todas as notas na página
            // de notas
            retrieveAndAddAllNotes(home.contentNotesPage.allNotesPanel, home.gridBagLayout, home.gridBagConstraints,
                    home, searchText);
            // Ajusta as restrições para cada componente na página de notas
            for (Component c : home.contentNotesPage.allNotesPanel.getComponents()) {
                home.gridBagLayout.setConstraints(c, home.gridBagConstraints);
                home.gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
            // Exibe uma mensagem de erro com a mensagem da exceção
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Este método é usado para redesenhar os lembretes na página inicial.
     * 
     * @param home
     */
    public void repaintReminders(Home home) {

        // Esta linha está chamando o outro método sobrecarregado repaintReminders com
        // um argumento "home" e um valor nulo para "searchText".
        repaintReminders(home, null);
    }

    /**
     * Este método é usado para redesenhar os lembretes na página inicial com a
     * capacidade de filtrar por texto de pesquisa.
     * 
     * @param home
     * @param searchText
     */
    public void repaintReminders(Home home, String searchText) {
        // Esta linha define o layout do "allRemindersPanel" em "contentRemindersPage"
        // para o "gridBagLayout" no objeto "home".
        home.contentRemindersPage.allRemindersPanel.setLayout(home.gridBagLayout);
        try {
            // Esta linha remove todos os componentes do "allRemindersPanel" em
            // "contentRemindersPage".
            home.contentRemindersPage.allRemindersPanel.removeAll();
            // Esta linha recupera todos os lembretes e os adiciona ao "allRemindersPanel"
            // em "contentRemindersPage".
            retrieveAndAddAllReminders(home.contentRemindersPage.allRemindersPanel, home.gridBagLayout,
                    home.gridBagConstraints, home, searchText);
            // Este loop define as restrições para cada componente no "allRemindersPanel" em
            // "contentRemindersPage".
            for (Component c : home.contentRemindersPage.allRemindersPanel.getComponents()) {
                home.gridBagLayout.setConstraints(c, home.gridBagConstraints);
                home.gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
            // Esta linha exibe um diálogo de mensagem de erro com a mensagem de exceção se
            // houver uma.
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Essa função deleta uma nota específica do banco de dados.
     * 
     * @param id
     * 
     */
    public void deleteNote(int id) {
        // Aqui é criada a string com a instrução SQL para deletar a nota com o ID
        // especificado.
        String sql = "DELETE FROM notes WHERE id = ?";

        try {
            // Aqui é criado um objeto PreparedStatement a partir da conexão com o banco de
            // dados (conn)
            // e da instrução SQL.
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Aqui é atribuido o valor do ID da nota a ser deletada na instrução SQL.
            pstmt.setInt(1, id);

            // Aqui é executada a instrução SQL de exclusão.
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Em caso de erro, uma mensagem é exibida com a mensagem de erro.
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     * 
     */
    public void close() {
        try {
            // Se a conexão não é nula, ela é fechada.
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            // Caso ocorra alguma exceção ao fechar a conexão, uma mensagem com a mensagem
            // de erro é exibida.
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}