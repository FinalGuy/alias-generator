package th.foju.aliasgenerator.syllables;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameFromSyllablesTest {

  NameFromSyllables cut;

  @Test
  public void shouldCreateNameFromSyllables() {
    testNameCreation("Maidrimmah", "-mai +c", "drim -v", "+mah");
  }

  private void testNameCreation(String expectation, String pre, String mid, String sur) {
    cut = new NameFromSyllables(new Syllable(pre), new Syllable(mid), new Syllable(sur));
    assertEquals(expectation, cut.text());
  }
}