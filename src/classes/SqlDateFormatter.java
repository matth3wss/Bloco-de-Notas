package classes;

import java.text.SimpleDateFormat;

public class SqlDateFormatter {
    
    public String formatSqlDate(java.sql.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
