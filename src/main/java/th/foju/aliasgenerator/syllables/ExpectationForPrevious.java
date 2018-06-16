package th.foju.aliasgenerator.syllables;


@FunctionalInterface
public interface ExpectationForPrevious {

  boolean acceptsPrevious(Syllable follower);

}
