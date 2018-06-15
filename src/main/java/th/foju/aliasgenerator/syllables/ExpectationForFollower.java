package th.foju.aliasgenerator.syllables;

public enum ExpectationForFollower {

  NONE {
    @Override
    boolean accepts(Syllable follower) {
      return true;
    }
  }, STARTS_WITH_VOCAL {
    @Override
    boolean accepts(Syllable follower) {
      return false;
    }
  }, STARTS_WITH_CONSONANT {
    @Override
    boolean accepts(Syllable follower) {
      return false;
    }
  };

  abstract boolean accepts(Syllable follower);
}
