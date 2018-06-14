package th.foju.aliasgenerator;

import java.util.Random;

class HashBasedKey implements Key {

  private final Random random = new Random();

  HashBasedKey(String stringKey) {
    long seed = stringKey.chars().asLongStream().reduce((a, b) -> a + b).orElseThrow(() -> new IllegalArgumentException("Leerer String"));
    random.setSeed(seed);
  }

  @Override
  public double nextRandom() {
    return random.nextDouble();
  }
}
