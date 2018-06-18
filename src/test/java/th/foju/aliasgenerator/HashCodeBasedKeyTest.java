package th.foju.aliasgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class HashCodeBasedKeyTest {

  HashCodeBasedKey cut;

  @Test
  public void shouldGenerateRandoms() {
    cut = new HashCodeBasedKey("myKey");
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    cut = new HashCodeBasedKey("anotherKey");
    cut = new HashCodeBasedKey("anotherKey!");
  }

  @Test
  public void shouldGenerateSameRandomsForSameKeyString() {
    cut = new HashCodeBasedKey("myKey");
    double random1 = cut.nextRandom();
    double random2 = cut.nextRandom();
    cut = new HashCodeBasedKey("myKey");
    assertEquals(random1, cut.nextRandom(), 0.0000d);
    assertEquals(random2, cut.nextRandom(), 0.0000d);
  }
}