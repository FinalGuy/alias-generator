package th.foju.aliasgenerator;

import java.util.Random;

class HashCodeBasedKey implements Key {

  private final Random random = new Random();

  HashCodeBasedKey(String stringKey) {
    random.setSeed(stringKey.hashCode());
  }

  @Override
  public double nextRandom() {
    return random.nextDouble();
  }
}
