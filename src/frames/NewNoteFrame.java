package frames;

import classes.*;
import main.Home;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Matheus
 */
public class NewNoteFrame extends javax.swing.JFrame {

    Home home = new Home();
    DBController db = new DBController("notes.db");
    NewNote newNote = new NewNote();
    SqlDateFormatter sdf = new SqlDateFormatter();

    public NewNoteFrame() {

        initComponents();
        myInitComponents();
        // formatSelectedDate();

    }

    public void myInitComponents() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                newNoteDescription.setForeground(Color.BLACK);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newNoteTitle = new javax.swing.JTextField();
        newNotePriority = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        newNoteDescription = new javax.swing.JTextPane();
        newNoteReminderDate = new com.toedter.calendar.JDateChooser();
        reminderDateLabel = new javax.swing.JLabel();
        btnAddNote = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        newNoteTitle.setText("Título");
        newNoteTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newNoteTitleMousePressed(evt);
            }
        });
        newNoteTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newNoteTitleKeyPressed(evt);
            }
        });

        newNotePriority.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Prioridade", "Urgente", "Alta", "Média", "Baixa", "Opcional", "Trivial" }));
        newNotePriority.setToolTipText("Prioridade");
        newNotePriority.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        newNoteDescription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newNoteDescription.setText("Descrição");
        newNoteDescription.setCaretPosition(0);
        newNoteDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newNoteDescriptionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(newNoteDescription);

        newNoteReminderDate.setDateFormatString("d/MM/y");

        reminderDateLabel.setText("Data: " + sdf.formatSqlDate(newNote.getDateCreated()));

        btnAddNote.setText("Add Nota");
        btnAddNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNoteActionPerformed(evt);
            }
        });

        jLabel1.setText("Lembrar-me");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(reminderDateLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(newNoteTitle,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 214,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newNotePriority,
                                                                javax.swing.GroupLayout.Alignment.TRAILING, 0, 94,
                                                                Short.MAX_VALUE)
                                                        .addComponent(newNoteReminderDate,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                Short.MAX_VALUE)
                                                        .addComponent(btnAddNote, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap()))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newNotePriority, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(3, 3, 3)
                                                .addComponent(newNoteReminderDate,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddNote))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reminderDateLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowActivated
        if (newNoteDescription.getText().equals("Descrição") && newNoteTitle.getText().equals("Título")) {
            newNoteDescription.setForeground(Color.LIGHT_GRAY);
            newNoteTitle.setForeground(Color.LIGHT_GRAY);
        }
    }// GEN-LAST:event_formWindowActivated

    private void newNoteDescriptionKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_newNoteDescriptionKeyPressed
        if (newNoteDescription.getText().equals("Descrição")) {
            newNoteDescription.setText("");
        }
        newNoteDescription.setForeground(Color.BLACK);
    }// GEN-LAST:event_newNoteDescriptionKeyPressed

    private void newNoteTitleKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_newNoteTitleKeyPressed
        if (newNoteTitle.getText().equals("Título")) {
            newNoteTitle.setText("");
        }
        newNoteTitle.setForeground(Color.BLACK);
    }// GEN-LAST:event_newNoteTitleKeyPressed

    private void newNoteTitleMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_newNoteTitleMousePressed
        if (newNoteTitle.getText().equals("Título")) {
            newNoteTitle.setCaretPosition(0);
        }
    }// GEN-LAST:event_newNoteTitleMousePressed

    private void btnAddNoteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddNoteActionPerformed
        newNote.setTitle(newNoteTitle.getText());
        newNote.setDescription(newNoteDescription.getText());
        newNote.setReminderDate(newNoteReminderDate.getDate());
        if (newNoteReminderDate.getDate() != null) {
            newNote.setReminderDate(newNoteReminderDate.getDate());
        }
        newNote.setPriority(newNotePriority.getSelectedItem().toString());

        Home home = new Home();
        try {
            home.contentNotesPage.allNotesPanel.removeAll();
            db.addNote(newNote);
            home.myInitComponents();
            home.contentNotesPage.allNotesPanel.revalidate();
            home.contentNotesPage.allNotesPanel.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }// GEN-LAST:event_btnAddNoteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewNoteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane newNoteDescription;
    private javax.swing.JComboBox<String> newNotePriority;
    private com.toedter.calendar.JDateChooser newNoteReminderDate;
    private javax.swing.JTextField newNoteTitle;
    private javax.swing.JLabel reminderDateLabel;
    // End of variables declaration//GEN-END:variables

}
