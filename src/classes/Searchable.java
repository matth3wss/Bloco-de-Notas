package classes;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import main.Home;

public interface Searchable {

        public void retrieveAndAddAllNotes(JPanel panel, GridBagLayout gridBagLayout,
                        GridBagConstraints gridBagConstraints, Home home) throws Exception;

        public void retrieveAndAddAllReminders(JPanel panel, GridBagLayout gridBagLayout,
                        GridBagConstraints gridBagConstraints, Home home) throws Exception;

        // public void repaintNotes(Home home);
        public void repaintNotes(Home home, String searchText);

        public void repaintReminders(Home home, String searchText);
}
