package th.foju.aliasgenerator;

import com.google.inject.Inject;

public class SyllablesBasedNamePool implements NamePool {

  private final Syllables syllables;

  @Inject
  public SyllablesBasedNamePool(Syllables syllables) {
    this.syllables = syllables;
  }

  @Override
  public String nameFor(String stringKey) {
    Key key = new HashBasedKey(stringKey);
    return syllables.preFor(key) + syllables.midFor(key) + syllables.surFor(key);
  }
}
