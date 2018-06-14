package th.foju.aliasgenerator.syllables;

import com.google.inject.Inject;
import th.foju.aliasgenerator.Key;
import th.foju.aliasgenerator.NamePool;

public class SyllablesBasedNamePool implements NamePool {

  private final Syllables syllables;

  @Inject
  public SyllablesBasedNamePool(Syllables syllables) {
    this.syllables = syllables;
  }

  @Override
  public String nameFor(Key key) {
    return createPre(key) + createMid(key) + createSur(key);
  }

  private String createSur(Key key) {
    return syllables.surFor(key);
  }

  private String createMid(Key key) {
    return syllables.midFor(key);
  }

  private String createPre(Key key) {
    return syllables.preFor(key);
  }
}
