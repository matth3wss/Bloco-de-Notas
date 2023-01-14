package pages;

import javax.swing.*;
import java.awt.*;

import frames.NewNoteFrame;

public class Notes extends javax.swing.JPanel {

    public Notes() {
        initComponents();
        myInitComponents();
    }

    public void myInitComponents() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                searchNotes.requestFocusInWindow();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchNotes = new javax.swing.JTextField();
        btnNewNote = new javax.swing.JButton();
        scrollPanelAllNotes = new javax.swing.JScrollPane();
        allNotesPanel = new javax.swing.JPanel();

        searchNotes.setText("Pesquisar notas");
        searchNotes.setCaretPosition(0);
        searchNotes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchNotesFocusGained(evt);
            }
        });
        searchNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchNotesKeyPressed(evt);
            }
        });

        btnNewNote.setText("Nova nota");
        btnNewNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewNoteMouseClicked(evt);
            }
        });

        allNotesPanel.setLayout(new java.awt.GridLayout());
        scrollPanelAllNotes.setViewportView(allNotesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(scrollPanelAllNotes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNewNote)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanelAllNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewNote)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewNoteMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnNewNoteMouseClicked
        JFrame newNoteFrame = new NewNoteFrame();
        newNoteFrame.setVisible(true);
    }// GEN-LAST:event_btnNewNoteMouseClicked

    private void searchNotesKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchNotesKeyPressed
        if (searchNotes.getText().equals("Pesquisar notas")) {
            searchNotes.setText("");
        }
        searchNotes.setForeground(Color.BLACK);
    }// GEN-LAST:event_searchNotesKeyPressed

    private void searchNotesFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_searchNotesFocusGained
        searchNotes.requestFocusInWindow();
        if (searchNotes.getText().equals("Pesquisar notas")) {
            searchNotes.setForeground(Color.LIGHT_GRAY);
        } else {
            searchNotes.setForeground(Color.BLACK);
        }
    }// GEN-LAST:event_searchNotesFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel allNotesPanel;
    private javax.swing.JButton btnNewNote;
    public javax.swing.JScrollPane scrollPanelAllNotes;
    public javax.swing.JTextField searchNotes;
    // End of variables declaration//GEN-END:variables
}
