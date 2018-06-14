package th.foju.aliasgenerator.syllables;

import com.google.inject.AbstractModule;

public class SyllableModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Syllables.class).to(FileBasedSyllables.class);
  }
}
