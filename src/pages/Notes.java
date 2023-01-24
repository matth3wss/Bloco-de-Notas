package pages;

import javax.swing.*;

import main.Home;

import java.awt.*;

//import frames.NewNoteFrame;

public class Notes extends javax.swing.JPanel {
    Home home;

    public Notes() {
        initComponents();
        myInitComponents();
    }

    public Notes(Home home) {
        this.home = home;
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
    @SuppressWarnings("")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        searchNotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchNotesMousePressed(evt);
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

        allNotesPanel.setBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        allNotesPanel.setLayout(new java.awt.GridBagLayout());
        scrollPanelAllNotes.setViewportView(allNotesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPanelAllNotes)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 274, Short.MAX_VALUE)
                                                        .addComponent(btnNewNote))
                                        .addComponent(searchNotes))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchNotes, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPanelAllNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 158,
                                        Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewNote)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void searchNotesMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_searchNotesMousePressed
        if (searchNotes.getText().equals("Pesquisar notas")) {
            searchNotes.setCaretPosition(0);
        }
    }// GEN-LAST:event_searchNotesMousePressed

    private void btnNewNoteMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnNewNoteMouseClicked
        home.tabs.setSelectedIndex(1);
    }// GEN-LAST:event_btnNewNoteMouseClicked

    private void searchNotesKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchNotesKeyPressed
        if (searchNotes.getText().equals("Pesquisar notas")) {
            searchNotes.setText("");
        }
        searchNotes.setForeground(Color.BLACK);
        // home.contentNotesPage.
        // home.db.searchAndAddAllNotes(contentNotesPage.allNotesPanel, gridBagLayout,
        // gridBagConstraints, this, searchNotes.getText());

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
    private javax.swing.JScrollPane scrollPanelAllNotes;
    public javax.swing.JTextField searchNotes;
    // End of variables declaration//GEN-END:variables
}
