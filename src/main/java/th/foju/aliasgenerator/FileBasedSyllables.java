package th.foju.aliasgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class FileBasedSyllables implements Syllables {

  private final List<String> preSyllables;
  private final List<String> midSyllables;
  private final List<String> surSyllables;

  public FileBasedSyllables() {
    this.preSyllables = new ArrayList<>();
    this.midSyllables = new ArrayList<>();
    this.surSyllables = new ArrayList<>();
    InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("./fantasy.txt");
    BufferedReader bufRead = new BufferedReader(new InputStreamReader(resourceAsStream));
    try {
      initSyllables(bufRead);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void initSyllables(BufferedReader bufRead) throws IOException {
    String line = "";
    while (line != null) {
      line = bufRead.readLine();
      if (line != null && !line.equals("")) {
        if (line.startsWith("-")) {
          preSyllables.add(line.substring(1).toLowerCase());
        } else if (line.startsWith("+")) {
          surSyllables.add(line.substring(1).toLowerCase());
        } else {
          midSyllables.add(line.toLowerCase());
        }
      }
    }
    bufRead.close();
  }

  @Override
  public String preFor(Key key) {
    return "PRE";
  }

  @Override
  public String midFor(Key key) {
    return "MID";
  }

  @Override
  public String surFor(Key key) {
    return "SUR";
  }
}
