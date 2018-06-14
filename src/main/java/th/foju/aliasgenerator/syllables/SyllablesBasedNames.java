package th.foju.aliasgenerator.syllables;

import com.google.inject.Inject;
import th.foju.aliasgenerator.Key;
import th.foju.aliasgenerator.NamePool;

public class SyllablesBasedNames implements NamePool {

  private final Syllables syllables;

  @Inject
  public SyllablesBasedNames(Syllables syllables) {
    this.syllables = syllables;
  }

  @Override
  public String nameFor(Key key) {
    return createPre(key) + createMid(key) + createSur(key);
  }

  private String createSur(Key key) {
    return syllables.surFor(key).pure();
  }

  private String createMid(Key key) {
    return syllables.midFor(key).pure();
  }

  private String createPre(Key key) {
    return syllables.preFor(key).pure();
  }
}
