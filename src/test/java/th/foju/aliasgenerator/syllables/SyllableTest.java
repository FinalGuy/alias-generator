package th.foju.aliasgenerator.syllables;

import static org.junit.Assert.assertEquals;

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
  public void shouldTellWhetherItAcceptsAGivenFollower() {
    // Successor starts with vocal
    testAcceptsFollower("-ansr +c", "ean", false);
    testAcceptsFollower("-ansr +v", "ean", true);
    // successor strart with consonant
    testAcceptsFollower("-ansr +v", "nim", false);
    testAcceptsFollower("-ansr +c", "nim", true);
    // current syllable contains data about predecessor und successor
    testAcceptsFollower("que -v +c", "nim", true);
  }

  private void testAcceptsFollower(String current, String follower, boolean expectation) {
    assertEquals(expectation, !new Syllable(current).doesNotAcceptAsNext(new Syllable(follower)));
  }

  @Test
  public void shouldTellWhetherItAcceptsAGivenPredecessor() {
    // Predecessor ends with consonant
    testAcceptsPredecessor("ean -v", "-ansr", false);
    testAcceptsPredecessor("ean -c", "-ansr", true);
    // Predecessor ends with vocal
    testAcceptsPredecessor("ean -v", "-ama", true);
    testAcceptsPredecessor("ean -c", "-ama", false);
  }

  private void testAcceptsPredecessor(String current, String pre, boolean expectation) {
    assertEquals(expectation, !new Syllable(current).doesNotAcceptAsPrevious(new Syllable(pre)));
  }


}