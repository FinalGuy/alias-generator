package th.foju.aliasgenerator.syllables;

import static org.junit.Assert.*;
import static th.foju.aliasgenerator.syllables.ExpectationForFollower.STARTS_WITH_CONSONANT;
import static th.foju.aliasgenerator.syllables.ExpectationForFollower.NONE;
import static th.foju.aliasgenerator.syllables.ExpectationForFollower.STARTS_WITH_VOCAL;

import org.junit.Test;

public class SyllableTest {


  Syllable cut;

  @Test
  public void shouldReturnPureVersionOfTheSyllable() {
    cut = new Syllable("-ansr +v");
    String result = cut.pure();
    assertEquals("ansr", result);
  }

  @Test
  public void shouldTellItsExpectationForTheFollowingSyllable() {
    testExpectationForFollowingSyllable("-ansr +v", STARTS_WITH_VOCAL);
    testExpectationForFollowingSyllable("-ansr +c", STARTS_WITH_CONSONANT);
    testExpectationForFollowingSyllable("-ansr", NONE);
  }

  private void testExpectationForFollowingSyllable(String pureSyllable, ExpectationForFollower expected) {
    cut = new Syllable(pureSyllable);
    ExpectationForFollower result = cut.expectationForFollowingSyllable();
    assertEquals(expected, result);
  }
}