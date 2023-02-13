package panels;

import java.awt.Color;
import main.Home;

public class NotesBlock extends javax.swing.JPanel {
    Home home;

    public NotesBlock(Home home) {
        this.home = home;
        initComponents();
    }

    public void myInitComponents() {
    }

    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notesBlockId = new javax.swing.JLabel();
        popupMenu = new javax.swing.JPopupMenu();
        editOption = new javax.swing.JMenuItem();
        deleteOption = new javax.swing.JMenuItem();
        notesBlockTitle = new javax.swing.JTextField();
        noteBlockDescription = new javax.swing.JTextArea();
        notesBlockReminderDateLabel = new javax.swing.JLabel();
        notesBlockPriority = new javax.swing.JLabel();
        btnEditNote = new javax.swing.JButton();

        notesBlockId.setText("Id");
        notesBlockId.setOpaque(true);

        editOption.setText("Editar");
        editOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOptionActionPerformed(evt);
            }
        });
        popupMenu.add(editOption);

        deleteOption.setText("Deletar");
        deleteOption.setToolTipText("");
        deleteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOptionActionPerformed(evt);
            }
        });
        popupMenu.add(deleteOption);

        notesBlockTitle.setEditable(false);
        notesBlockTitle.setText("Título");
        notesBlockTitle.setBorder(null);

        noteBlockDescription.setEditable(false);
        noteBlockDescription.setColumns(5);
        noteBlockDescription.setRows(5);
        noteBlockDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        noteBlockDescription.setEnabled(false);

        notesBlockReminderDateLabel.setText("Data do lembrete");

        notesBlockPriority.setBackground(new java.awt.Color(255, 255, 255));
        notesBlockPriority.setText("Prioridade");

        btnEditNote.setText("⋮");
        btnEditNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditNoteMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditNoteMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(notesBlockPriority))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(notesBlockReminderDateLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(notesBlockTitle,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(noteBlockDescription))
                                                .addGap(2, 2, 2)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(notesBlockTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(notesBlockPriority))
                                .addGap(2, 2, 2)
                                .addComponent(noteBlockDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(notesBlockReminderDateLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditNoteMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnEditNoteMousePressed
        popupMenu.show(btnEditNote, evt.getX(), evt.getY());
    }// GEN-LAST:event_btnEditNoteMousePressed

    private void btnEditNoteMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnEditNoteMouseReleased
        popupMenu.show(btnEditNote, evt.getX(), evt.getY());
    }// GEN-LAST:event_btnEditNoteMouseReleased

    private void editOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editOptionActionPerformed
        id = Integer.parseInt(notesBlockId.getText());
        int index = home.tabs.indexOfTab("Editar Nota");
        if (index == -1) {
            home.tabs.addTab("Editar Nota", home.editNoteTab);
            index = home.tabs.indexOfTab("Editar Nota");
        }
        home.tabs.setSelectedIndex(index);
        home.db.retrieveAndSetNote(id, home);

        if (home.noteTitle.getText().equals("Título")) {
            home.noteTitle.setForeground(Color.LIGHT_GRAY);
            home.noteTitle.setCaretPosition(0);
        } else {
            home.noteTitle.setForeground(Color.BLACK);
        }
        if (home.noteDescription.getText().equals("Descrição")) {
            home.noteDescription.setForeground(Color.LIGHT_GRAY);
            home.noteDescription.setCaretPosition(0);
        } else {
            home.noteDescription.setForeground(Color.BLACK);
        }

    }// GEN-LAST:event_editOptionActionPerformed

    private void deleteOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteOptionActionPerformed
        id = Integer.parseInt(notesBlockId.getText());
        home.db.deleteNote(id);
        home.db.repaintNotes(home);
        home.db.repaintReminders(home);
    }// GEN-LAST:event_deleteOptionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditNote;
    private javax.swing.JMenuItem deleteOption;
    private javax.swing.JMenuItem editOption;
    public javax.swing.JTextArea noteBlockDescription;
    public javax.swing.JLabel notesBlockId;
    public javax.swing.JLabel notesBlockPriority;
    public javax.swing.JLabel notesBlockReminderDateLabel;
    public javax.swing.JTextField notesBlockTitle;
    public javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables

    public int id;
}
