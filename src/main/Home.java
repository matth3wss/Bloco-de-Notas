package main;

import classes.*;
import pages.*;
import java.awt.*;
import javax.swing.*;

public class Home extends javax.swing.JFrame {

    public DBController db = new DBController("notes.db");
    public CardLayout cardLayout = new CardLayout();
    NewNote newNote = new NewNote();
    NewNote updateNote = new NewNote();
    SqlDateFormatter sdf = new SqlDateFormatter();
    Notes notes = new Notes(this);
    Reminders reminders = new Reminders(this);

    public GridBagLayout gridBagLayout = new GridBagLayout();
    public GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTHWEST,
            GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);

    public Home() {
        initComponents();
        myInitComponents();
        repaintNotes();
        repaintReminders();
    }

    public Home(Notes notes, Reminders reminders) {
        this.notes = notes;
        this.reminders = reminders;
        initComponents();
        myInitComponents();
        repaintNotes();
        repaintReminders();
    }

    public void myInitComponents() {

        contentPanel.setLayout(cardLayout);
        contentPanel.add(contentNotesPage, "NewNote");
        contentPanel.add(contentRemindersPage, "NewTaskList");
    }

    public void repaintNotes() {
        contentNotesPage.allNotesPanel.setLayout(gridBagLayout);
        try {
            contentNotesPage.allNotesPanel.removeAll();
            db.retrieveAndAddAllNotes(contentNotesPage.allNotesPanel, gridBagLayout, gridBagConstraints, this);
            for (Component c : contentNotesPage.allNotesPanel.getComponents()) {
                gridBagLayout.setConstraints(c, gridBagConstraints);
                gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void repaintReminders() {
        contentRemindersPage.allRemindersPanel.setLayout(gridBagLayout);
        try {
            contentRemindersPage.allRemindersPanel.removeAll();
            db.retrieveAndAddAllReminders(contentRemindersPage.allRemindersPanel, gridBagLayout, gridBagConstraints,
                    this);
            for (Component c : contentRemindersPage.allRemindersPanel.getComponents()) {
                gridBagLayout.setConstraints(c, gridBagConstraints);
                gridBagConstraints.gridy++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noteId = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        homeTab = new javax.swing.JPanel();
        sideMenuPanel = new javax.swing.JPanel();
        btnNotes = new javax.swing.JButton();
        btnReminders = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        contentNotesPage = new pages.Notes(this);
        contentRemindersPage = new pages.Reminders(this);
        newNoteTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newNoteDescription = new javax.swing.JTextArea();
        newNoteTitle = new javax.swing.JTextField();
        newNotePriority = new javax.swing.JComboBox<>();
        newNoteReminderDate = new com.toedter.calendar.JDateChooser();
        reminderDateLabel = new javax.swing.JLabel();
        btnAddNote = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        editNoteTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteDescription = new javax.swing.JTextArea();
        noteTitle = new javax.swing.JTextField();
        notePriority = new javax.swing.JComboBox<>();
        noteReminderDate = new com.toedter.calendar.JDateChooser();
        noteDateCreatedLabel = new javax.swing.JLabel();
        btnSaveNote = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        closeEditTab = new javax.swing.JButton();

        noteId.setText("id");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        sideMenuPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNotes.setText("Notas");
        btnNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotesActionPerformed(evt);
            }
        });

        btnReminders.setText("Lembretes");
        btnReminders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemindersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideMenuPanelLayout = new javax.swing.GroupLayout(sideMenuPanel);
        sideMenuPanel.setLayout(sideMenuPanelLayout);
        sideMenuPanelLayout.setHorizontalGroup(
                sideMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideMenuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sideMenuPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnNotes, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReminders, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        sideMenuPanelLayout.setVerticalGroup(
                sideMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideMenuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNotes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReminders)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        contentPanel.setLayout(new java.awt.CardLayout());
        contentPanel.add(contentNotesPage, "card2");
        contentPanel.add(contentRemindersPage, "card3");

        javax.swing.GroupLayout homeTabLayout = new javax.swing.GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
                homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sideMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                .addContainerGap()));
        homeTabLayout.setVerticalGroup(
                homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sideMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 437,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        tabs.addTab("Home", homeTab);

        newNoteDescription.setColumns(20);
        newNoteDescription.setRows(5);
        newNoteDescription.setText("Descrição");
        newNoteDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newNoteDescriptionMousePressed(evt);
            }
        });
        newNoteDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newNoteDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(newNoteDescription);

        newNoteTitle.setText("Título");
        newNoteTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newNoteTitleMousePressed(evt);
            }
        });
        newNoteTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newNoteTitleKeyTyped(evt);
            }
        });

        newNotePriority.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Prioridade", "Urgente", "Alta", "Média", "Baixa", "Opcional", "Trivial" }));
        newNotePriority.setToolTipText("Prioridade");
        newNotePriority.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        newNoteReminderDate.setToolTipText("Escolha a data");
        newNoteReminderDate.setDateFormatString("d/MM/y");

        reminderDateLabel.setText("Data de criação: " + sdf.formatSqlDate(newNote.getDateCreated()));

        btnAddNote.setText("Add Nota");
        btnAddNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNoteActionPerformed(evt);
            }
        });

        jLabel1.setText("Lembrar-me");

        javax.swing.GroupLayout newNoteTabLayout = new javax.swing.GroupLayout(newNoteTab);
        newNoteTab.setLayout(newNoteTabLayout);
        newNoteTabLayout.setHorizontalGroup(
                newNoteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newNoteTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(newNoteTabLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(newNoteTabLayout.createSequentialGroup()
                                                .addGroup(newNoteTabLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(reminderDateLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 202,
                                                                Short.MAX_VALUE)
                                                        .addComponent(newNoteTitle))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addGap(30, 30, 30)
                                                .addGroup(newNoteTabLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(newNoteTabLayout.createSequentialGroup()
                                                                .addComponent(newNoteReminderDate,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(newNotePriority,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 238,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnAddNote, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap()));
        newNoteTabLayout.setVerticalGroup(
                newNoteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newNoteTabLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(newNoteTabLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(newNoteTabLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(newNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(newNotePriority)
                                        .addComponent(newNoteReminderDate, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        newNoteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnAddNote)
                                                .addComponent(reminderDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                                .addContainerGap()));

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(1000);
        newNoteReminderDate.getAccessibleContext().setAccessibleName("Escolha a data");
        newNoteReminderDate.getAccessibleContext().setAccessibleDescription("");

        tabs.addTab("Nova Nota", newNoteTab);

        noteDescription.setColumns(20);
        noteDescription.setRows(5);
        noteDescription.setText("Descrição");
        noteDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                noteDescriptionMousePressed(evt);
            }
        });
        noteDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteDescriptionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(noteDescription);

        noteTitle.setText("Título");
        noteTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                noteTitleMousePressed(evt);
            }
        });
        noteTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteTitleKeyTyped(evt);
            }
        });

        notePriority.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Prioridade", "Urgente", "Alta", "Média", "Baixa", "Opcional", "Trivial" }));
        notePriority.setToolTipText("Prioridade");
        notePriority.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        noteReminderDate.setToolTipText("Escolha a data");
        noteReminderDate.setDateFormatString("d/MM/y");

        noteDateCreatedLabel.setText("Data de criação: " + sdf.formatSqlDate(newNote.getDateCreated()));

        btnSaveNote.setText("Salvar Nota");
        btnSaveNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveNoteMousePressed(evt);
            }
        });

        jLabel3.setText("Lembrar-me");

        closeEditTab.setText("Fechar");
        closeEditTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeEditTabMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout editNoteTabLayout = new javax.swing.GroupLayout(editNoteTab);
        editNoteTab.setLayout(editNoteTabLayout);
        editNoteTabLayout.setHorizontalGroup(
                editNoteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editNoteTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editNoteTabLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(editNoteTabLayout.createSequentialGroup()
                                                .addGroup(editNoteTabLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(editNoteTabLayout.createSequentialGroup()
                                                                .addComponent(noteTitle,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 202,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel3))
                                                        .addComponent(noteDateCreatedLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 202,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(editNoteTabLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(editNoteTabLayout.createSequentialGroup()
                                                                .addComponent(noteReminderDate,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(notePriority,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 238,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnSaveNote, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(6, 6, 6)
                                                .addComponent(closeEditTab)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        editNoteTabLayout.setVerticalGroup(
                editNoteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editNoteTabLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(editNoteTabLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(noteTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(closeEditTab)
                                        .addGroup(editNoteTabLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(noteReminderDate,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(notePriority, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(editNoteTabLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(noteDateCreatedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSaveNote))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addGap(8, 8, 8)));

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(1000);

        tabs.addTab("Editar Nota", editNoteTab);

        getContentPane().add(tabs);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_tabsStateChanged
        switch (tabs.getSelectedIndex()) {
            case 0 -> {
                newNoteTitle.setText("Título");
                newNoteDescription.setText("Descrição");
                noteTitle.setText("Título");
                noteDescription.setText("Descrição");
            }
            case 1 -> {
                if (newNoteTitle.getText().equals("Título")) {
                    newNoteTitle.setForeground(Color.LIGHT_GRAY);
                    newNoteTitle.setCaretPosition(0);
                } else {
                    newNoteTitle.setForeground(Color.BLACK);
                }
                if (newNoteDescription.getText().equals("Descrição")) {
                    newNoteDescription.setForeground(Color.LIGHT_GRAY);
                    newNoteDescription.setCaretPosition(0);
                } else {
                    newNoteDescription.setForeground(Color.BLACK);
                }
                noteTitle.setText("Título");
                noteDescription.setText("Descrição");
            }
            case 2 -> {
                if (noteTitle.getText().equals("Título")) {
                    noteTitle.setForeground(Color.LIGHT_GRAY);
                    noteTitle.setCaretPosition(0);
                } else {
                    noteTitle.setForeground(Color.BLACK);
                }
                if (noteDescription.getText().equals("Descrição")) {
                    noteDescription.setForeground(Color.LIGHT_GRAY);
                    noteDescription.setCaretPosition(0);
                } else {
                    noteDescription.setForeground(Color.BLACK);
                }
                newNoteTitle.setText("Título");
                newNoteDescription.setText("Descrição");

            }
        }
    }// GEN-LAST:event_tabsStateChanged

    private void btnNotesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNotesActionPerformed
        cardLayout.show(contentPanel, "NewNote");
        contentNotesPage.searchNotes.requestFocusInWindow();
        contentRemindersPage.searchReminders.setText("Pesquisar lembretes");
        contentRemindersPage.searchReminders.setCaretPosition(0);
    }// GEN-LAST:event_btnNotesActionPerformed

    private void btnRemindersActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemindersActionPerformed
        cardLayout.show(contentPanel, "NewTaskList");
        contentRemindersPage.searchReminders.requestFocusInWindow();
        contentNotesPage.searchNotes.setText("Pesquisar notas");
        contentNotesPage.searchNotes.setCaretPosition(0);
    }// GEN-LAST:event_btnRemindersActionPerformed

    private void newNoteTitleMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_newNoteTitleMousePressed
        if (newNoteTitle.getText().equals("Título")) {
            newNoteTitle.setCaretPosition(0);
        }
    }// GEN-LAST:event_newNoteTitleMousePressed

    private void newNoteDescriptionMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_newNoteDescriptionMousePressed
        if (newNoteDescription.getText().equals("Descrição")) {
            newNoteDescription.setCaretPosition(0);
        }

    }// GEN-LAST:event_newNoteDescriptionMousePressed

    private void newNoteTitleKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_newNoteTitleKeyTyped
        if (newNoteTitle.getText().equals("Título")) {
            newNoteTitle.setText("");
        }
        newNoteTitle.setForeground(Color.BLACK);
    }// GEN-LAST:event_newNoteTitleKeyTyped

    private void newNoteDescriptionKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_newNoteDescriptionKeyTyped
        if (newNoteDescription.getText().equals("Descrição")) {
            newNoteDescription.setText("");
        }
        newNoteDescription.setForeground(Color.BLACK);
    }// GEN-LAST:event_newNoteDescriptionKeyTyped

    private void btnAddNoteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddNoteActionPerformed

        newNote.setTitle(newNoteTitle.getText());

        if (!newNoteDescription.getText().equals("Descrição")) {
            newNote.setDescription(newNoteDescription.getText());
        }
        if (newNoteReminderDate.getDate() != null) {
            newNote.setReminderDate(newNoteReminderDate.getDate());
        }
        newNote.setPriority(newNotePriority.getSelectedItem().toString());

        try {
            db.addNote(newNote);
            repaintNotes();
            repaintReminders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btnAddNoteActionPerformed

    private void closeEditTabMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_closeEditTabMouseClicked
        int index = tabs.getSelectedIndex();
        tabs.remove(index);
        tabs.setSelectedIndex(0);
    }// GEN-LAST:event_closeEditTabMouseClicked

    private void noteTitleMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_noteTitleMousePressed
        if (noteTitle.getText().equals("Título")) {
            noteTitle.setCaretPosition(0);
        }
    }// GEN-LAST:event_noteTitleMousePressed

    private void noteDescriptionMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_noteDescriptionMousePressed
        if (noteDescription.getText().equals("Descrição")) {
            noteDescription.setCaretPosition(0);
        }
    }// GEN-LAST:event_noteDescriptionMousePressed

    private void noteTitleKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_noteTitleKeyTyped
        if (noteTitle.getText().equals("Título")) {
            noteTitle.setText("");
        }
        noteTitle.setForeground(Color.BLACK);
    }// GEN-LAST:event_noteTitleKeyTyped

    private void noteDescriptionKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_noteDescriptionKeyTyped
        if (noteDescription.getText().equals("Descrição")) {
            noteDescription.setText("");
        }
        noteDescription.setForeground(Color.BLACK);
    }// GEN-LAST:event_noteDescriptionKeyTyped

    private void btnSaveNoteMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnSaveNoteMousePressed
        int id = Integer.parseInt(noteId.getText());

        updateNote.setTitle(noteTitle.getText());
        updateNote.setDescription(noteDescription.getText());
        updateNote.setPriority(notePriority.getSelectedItem().toString());
        updateNote.setReminderDate(noteReminderDate.getDate());


        try {
            db.updateNotes(id, updateNote);
            repaintNotes();
            repaintReminders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btnSaveNoteMousePressed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNote;
    private javax.swing.JButton btnNotes;
    private javax.swing.JButton btnReminders;
    private javax.swing.JButton btnSaveNote;
    private javax.swing.JButton closeEditTab;
    public pages.Notes contentNotesPage;
    public javax.swing.JPanel contentPanel;
    public pages.Reminders contentRemindersPage;
    public javax.swing.JPanel editNoteTab;
    private javax.swing.JPanel homeTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea newNoteDescription;
    private javax.swing.JComboBox<String> newNotePriority;
    private com.toedter.calendar.JDateChooser newNoteReminderDate;
    private javax.swing.JPanel newNoteTab;
    private javax.swing.JTextField newNoteTitle;
    public javax.swing.JLabel noteDateCreatedLabel;
    public javax.swing.JTextArea noteDescription;
    public javax.swing.JLabel noteId;
    public javax.swing.JComboBox<String> notePriority;
    public com.toedter.calendar.JDateChooser noteReminderDate;
    public javax.swing.JTextField noteTitle;
    private javax.swing.JLabel reminderDateLabel;
    private javax.swing.JPanel sideMenuPanel;
    public javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
