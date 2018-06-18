package th.foju.aliasgenerator.syllables;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class LineTest {

  Line cut;

  @Test
  public void shouldPutPreSyllablesIntoTheRightBucket() {
    cut = new Line("-ash");
    List<Syllable> bucket = new LinkedList<>();
    cut.putSyllableIntoMatchingBucket(bucket, null, null);
    assertTrue(bucket.contains(new Syllable("ash")));
  }

  @Test
  public void shouldPutMidSyllablesIntoTheRightBucket() {
    cut = new Line("ash");
    List<Syllable> bucket = new LinkedList<>();
    cut.putSyllableIntoMatchingBucket(null, bucket, null);
    assertTrue(bucket.contains(new Syllable("ash")));
  }

  @Test
  public void shouldPutSurSyllablesIntoTheRightBucket() {
    cut = new Line("+ash");
    List<Syllable> bucket = new LinkedList<>();
    cut.putSyllableIntoMatchingBucket(null, null, bucket);
    assertTrue(bucket.contains(new Syllable("ash")));
  }
}