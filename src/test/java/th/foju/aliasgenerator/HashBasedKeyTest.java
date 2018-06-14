package th.foju.aliasgenerator;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashBasedKeyTest {

  HashBasedKey cut;

  @Test
  public void shouldGenerateRandoms() {
    cut = new HashBasedKey("myKey");
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    assertNotEquals(cut.nextRandom(), cut.nextRandom(), 0.0000d);
    cut = new HashBasedKey("anotherKey");
    cut = new HashBasedKey("anotherKey!");
  }

  @Test
  public void shouldGenerateSameRandomsForSameKeyString() {
    cut = new HashBasedKey("myKey");
    double random1 = cut.nextRandom();
    double random2 = cut.nextRandom();
    cut = new HashBasedKey("myKey");
    assertEquals(random1, cut.nextRandom(), 0.0000d);
    assertEquals(random2, cut.nextRandom(), 0.0000d);
  }
}