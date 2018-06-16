package th.foju.aliasgenerator.syllables;

import com.google.inject.Inject;
import th.foju.aliasgenerator.Key;
import th.foju.aliasgenerator.Name;
import th.foju.aliasgenerator.NamePool;

public class SyllablesBasedNames implements NamePool {

  private final Syllables syllables;

  @Inject
  public SyllablesBasedNames(Syllables syllables) {
    this.syllables = syllables;
  }

  @Override
  public Name nameFor(Key key) {
    Syllable pre = createPre(key);
    Syllable mid = createMid(key, pre);
    Syllable sur = createSur(key, mid);
    return new NameFromSyllables(pre, mid, sur);
  }

  private Syllable createPre(Key key) {
    return syllables.preFor(key);
  }

  private Syllable createMid(Key key, Syllable pre) {
    Syllable mid = syllables.midFor(key);
    while (pre.doesNotAcceptAsNext(mid) || mid.doesNotAcceptAsPrevious(pre)) {
      mid = syllables.midFor(key);
    }
    return mid;
  }

  private Syllable createSur(Key key, Syllable mid) {
    Syllable sur = syllables.surFor(key);
    while (mid.doesNotAcceptAsNext(sur) || sur.doesNotAcceptAsPrevious(mid)) {
      sur = syllables.surFor(key);
    }
    return sur;
  }
}
