package pages;

import main.Home;
import java.awt.*;

import javax.swing.JOptionPane;

public class Reminders extends javax.swing.JPanel {
    Home home;

    public Reminders() {
        initComponents();
        myInitComponents();
    }

    public Reminders(Home home) {
        this.home = home;
        initComponents();
        myInitComponents();
    }

    public void myInitComponents() {
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

        searchReminders = new javax.swing.JTextField();
        btnNewReminder = new javax.swing.JButton();
        scrollPanelAllReminders = new javax.swing.JScrollPane();
        allRemindersPanel = new javax.swing.JPanel();

        searchReminders.setText("Pesquisar lembretes");
        searchReminders.setCaretPosition(0);
        searchReminders.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchRemindersFocusGained(evt);
            }
        });
        searchReminders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchRemindersMousePressed(evt);
            }
        });
        searchReminders.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchRemindersKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchRemindersKeyTyped(evt);
            }
        });

        btnNewReminder.setText("Novo Lembrete");
        btnNewReminder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewReminderMouseClicked(evt);
            }
        });

        allRemindersPanel.setBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        allRemindersPanel.setLayout(new java.awt.GridBagLayout());
        scrollPanelAllReminders.setViewportView(allRemindersPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchReminders)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(btnNewReminder))
                                        .addComponent(scrollPanelAllReminders, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                198, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchReminders, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPanelAllReminders, javax.swing.GroupLayout.DEFAULT_SIZE, 151,
                                        Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewReminder)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void searchRemindersMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_searchRemindersMousePressed
        if (searchReminders.getText().equals("Pesquisar lembretes")) {
            searchReminders.setCaretPosition(0);
        }
    }// GEN-LAST:event_searchRemindersMousePressed

    private void btnNewReminderMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnNewReminderMouseClicked
        home.tabs.setSelectedIndex(1);
    }// GEN-LAST:event_btnNewReminderMouseClicked

    private void searchRemindersFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_searchRemindersFocusGained
        searchReminders.requestFocusInWindow();
        if (searchReminders.getText().equals("Pesquisar lembretes")) {
            searchReminders.setForeground(Color.LIGHT_GRAY);
        } else {
            searchReminders.setForeground(Color.BLACK);
        }

    }// GEN-LAST:event_searchRemindersFocusGained

    private void searchRemindersKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchRemindersKeyTyped
        if (searchReminders.getText().equals("Pesquisar lembretes")) {
            searchReminders.setText("");
        }
        searchReminders.setForeground(Color.BLACK);
    }// GEN-LAST:event_searchRemindersKeyTyped

    private void searchRemindersKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchRemindersKeyReleased
        home.contentRemindersPage.allRemindersPanel.removeAll();
        try {
            home.db.retrieveAndAddAllReminders(home.contentRemindersPage.allRemindersPanel, home.gridBagLayout,
                    home.gridBagConstraints, home,
                    searchReminders.getText().equals("") ? null : searchReminders.getText());
            home.db.repaintReminders(home,
                    searchReminders.getText().equals("") ? null : searchReminders.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_searchRemindersKeyReleased
     // Variables declaration - do not modify//GEN-BEGIN:variables

    public javax.swing.JPanel allRemindersPanel;
    private javax.swing.JButton btnNewReminder;
    private javax.swing.JScrollPane scrollPanelAllReminders;
    public javax.swing.JTextField searchReminders;
    // End of variables declaration//GEN-END:variables
}
