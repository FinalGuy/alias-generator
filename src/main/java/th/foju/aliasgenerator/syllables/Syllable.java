package th.foju.aliasgenerator.syllables;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Syllable {

  private static final List<Character> VOCALS = Arrays.asList('a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'õ', 'ü', 'y');
  private static final List<Character> CONSONANTS = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y');

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

  boolean doesNotAcceptAsNext(Syllable next) {
    return !expectationForFollower().acceptsNext(next);
  }

  boolean doesNotAcceptAsPrevious(Syllable previous) {
    return !expectationForPrevious().acceptsPrevious(previous);
  }

  private ExpectationForPrevious expectationForPrevious() {
    List<String> expectations = expectations();
    if (expectations.isEmpty()) {
      return (syllable -> true);
    }
    if (expectations.contains("-v")) {
      return (Syllable::endsWithVocal);
    }
    return (Syllable::endsWithConsonant);
  }

  private ExpectationForFollower expectationForFollower() {
    List<String> expectations = expectations();
    if (expectations.isEmpty()) {
      return (syllable -> true);
    }
    if (expectations.contains("+v")) {
      return (Syllable::startsWithVocal);
    }
    return (Syllable::startsWithConsonant);
  }

  private List<String> expectations() {
    return Arrays.asList(text.trim().split(" ")).stream().skip(1).collect(Collectors.toList());
  }

  private boolean startsWithConsonant() {
    return CONSONANTS.stream().anyMatch(c -> c.equals(firstCharacter()));
  }

  private boolean startsWithVocal() {
    return VOCALS.stream().anyMatch(v -> v.equals(firstCharacter()));
  }

  private boolean endsWithVocal() {
    return VOCALS.stream().anyMatch(v -> v.equals(lastCharacter()));
  }

  private boolean endsWithConsonant() {
    return CONSONANTS.stream().anyMatch(c -> c.equals(lastCharacter()));
  }

  private char lastCharacter() {
    return pure().charAt(pure().length() - 1);
  }

  private char firstCharacter() {
    return pure().charAt(0);
  }
}
