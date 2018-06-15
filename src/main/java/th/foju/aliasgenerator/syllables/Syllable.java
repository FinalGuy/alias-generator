package th.foju.aliasgenerator.syllables;

import static th.foju.aliasgenerator.syllables.ExpectationForFollower.STARTS_WITH_CONSONANT;
import static th.foju.aliasgenerator.syllables.ExpectationForFollower.NONE;
import static th.foju.aliasgenerator.syllables.ExpectationForFollower.STARTS_WITH_VOCAL;

class Syllable {

  private static final char[] VOCALS = {'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'õ', 'ü', 'y'};
  private static final char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y'};

  private String text;

  Syllable(String text) {
    this.text = text;
  }

  String pure() {
    String pure = text.trim();
    if (pure.startsWith("+") || pure.startsWith("-")) {
      pure = pure.substring(1);
    }
    if (pure.contains(" ")) {
      pure = pure.split(" ")[0];
    }
    return pure;
  }

  ExpectationForFollower expectationForFollowingSyllable() {
    String[] components = text.split(" ");
    if (components.length == 1) {
      return NONE;
    }
    if (components[1].endsWith("v")) {

      return STARTS_WITH_VOCAL;
    }
    return STARTS_WITH_CONSONANT;
  }

  boolean doesNotAcceptAsFollower(Syllable follower) {
    return !expectationForFollowingSyllable().accepts(follower);
  }

  boolean doesNotAcceptAsPredecessor(Syllable predecessor) {
    return false;
  }
}
