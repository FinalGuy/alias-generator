package th.foju.aliasgenerator.syllables;


@FunctionalInterface
public interface ExpectationForFollower {

  boolean acceptsNext(Syllable follower);

}
