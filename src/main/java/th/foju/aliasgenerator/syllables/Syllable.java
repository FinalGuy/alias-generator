package th.foju.aliasgenerator.syllables;

class Syllable {

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
}
