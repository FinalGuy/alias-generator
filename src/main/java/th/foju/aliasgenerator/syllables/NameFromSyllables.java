package th.foju.aliasgenerator.syllables;

import java.util.Arrays;
import th.foju.aliasgenerator.Name;

public class NameFromSyllables implements Name {

  private Syllable[] syllables;

  NameFromSyllables(Syllable... syllables) {
    this.syllables = syllables;
  }

  @Override
  public String text() {
    return Arrays.stream(syllables)
      .map(Syllable::pure)
      .reduce((a, b) -> a + b)
      .map(s -> firstCharacterUpperCase(s))
      .orElse("");
  }

  private String firstCharacterUpperCase(String s) {
    return s.substring(0, 1).toUpperCase().concat(s.substring(1));
  }
}
