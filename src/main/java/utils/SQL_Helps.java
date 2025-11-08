package utils;

import java.text.MessageFormat;

public class SQL_Helps {
  public String SQL_SELECT_ALL(String table ) {
    return MessageFormat.format("SELECT {0}_ID, {0} FROM {0}", table);
  }

  public String SQL_INSERT(String table) {
    return MessageFormat.format("INSERT INTO {0} ({0}) VALUES (?)", table);
  }
}
