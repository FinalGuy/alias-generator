package th.foju.aliasgenerator.syllables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import th.foju.aliasgenerator.Key;

public class FileBasedSyllables implements Syllables {

  private final List<Syllable> preSyllables;
  private final List<Syllable> midSyllables;
  private final List<Syllable> surSyllables;

  public FileBasedSyllables() {
    this.preSyllables = new ArrayList<>();
    this.midSyllables = new ArrayList<>();
    this.surSyllables = new ArrayList<>();
    InputStream resourceAsStream = this.getClass().getResourceAsStream("/elven.txt");
    BufferedReader bufRead = new BufferedReader(new InputStreamReader(resourceAsStream));
    try {
      initSyllables(bufRead);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void initSyllables(BufferedReader bufRead) throws IOException {
    String line = "";
    while (line != null) {
      line = bufRead.readLine();
      if (line != null && !line.equals("")) {
        if (line.startsWith("-")) {
          preSyllables.add(new Syllable(line.substring(1).toLowerCase()));
        } else if (line.startsWith("+")) {
          surSyllables.add(new Syllable(line.substring(1).toLowerCase()));
        } else {
          midSyllables.add(new Syllable(line.toLowerCase()));
        }
      }
    }
    bufRead.close();
  }

  @Override
  public Syllable preFor(Key key) {
    return syllableFor(key, preSyllables);
  }

  @Override
  public Syllable midFor(Key key) {
    return syllableFor(key, midSyllables);
  }

  @Override
  public Syllable surFor(Key key) {
    return syllableFor(key, surSyllables);
  }

  private Syllable syllableFor(Key key, List<Syllable> syllables) {
    return syllables.get((int) (key.nextRandom() * syllables.size()));
  }
}
