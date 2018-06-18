package th.foju.aliasgenerator.syllables;

import java.util.function.Function;
import th.foju.aliasgenerator.Key;
import th.foju.aliasgenerator.Name;
import th.foju.aliasgenerator.NamePool;

public class SyllablesBasedNames implements NamePool {

  private final Syllables syllables;

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
    return findMatchingNextFor(pre, key, syllables::midFor);
  }

  private Syllable createSur(Key key, Syllable mid) {
    return findMatchingNextFor(mid, key, syllables::surFor);
  }

  private Syllable findMatchingNextFor(Syllable current, Key key, Function<Key, Syllable> fetchCandidate) {
    Syllable candidate = fetchCandidate.apply(key);
    while (current.doesNotAcceptAsNext(candidate) || candidate.doesNotAcceptAsPrevious(current)) {
      candidate = fetchCandidate.apply(key);
    }
    return candidate;
  }
}
