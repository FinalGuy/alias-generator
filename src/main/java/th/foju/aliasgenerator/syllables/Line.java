package th.foju.aliasgenerator.syllables;

import java.util.List;

class Line {

  private String content;

  Line(String content) {
    this.content = content;
  }

  void putSyllableIntoMatchingBucket(List<Syllable> preSyllables, List<Syllable> midSyllables, List<Syllable> surSyllables) {
    if (content == null || "".equals(content)) {
      return;
    }
    if (content.startsWith("-")) {
      preSyllables.add(new Syllable(content.substring(1).toLowerCase()));
    } else if (content.startsWith("+")) {
      surSyllables.add(new Syllable(content.substring(1).toLowerCase()));
    } else {
      midSyllables.add(new Syllable(content.toLowerCase()));
    }
  }
}
