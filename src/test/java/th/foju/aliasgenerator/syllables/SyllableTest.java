package th.foju.aliasgenerator.syllables;

import static org.junit.Assert.*;

import org.junit.Test;

public class SyllableTest {


  Syllable cut;

  @Test
  public void shouldReturnPureVersionOfTheSyllable() {
    cut = new Syllable("-ansr +v");
    String result = cut.pure();
    assertEquals("ansr", result);
  }
}