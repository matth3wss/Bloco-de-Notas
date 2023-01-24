package classes;

import java.sql.*;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import main.Home;

public interface Searchable {

        public ResultSet searchNotes(String query);

        public ResultSet searchReminders(String query);

        public void retrieveAndAddAllNotes(JPanel panel, GridBagLayout gridBagLayout,
                        GridBagConstraints gridBagConstraints, Home home) throws Exception;

        public void retrieveAndAddAllReminders(JPanel panel, GridBagLayout gridBagLayout,
                        GridBagConstraints gridBagConstraints, Home home) throws Exception;
}
