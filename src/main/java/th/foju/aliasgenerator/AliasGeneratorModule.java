package th.foju.aliasgenerator;

import com.google.inject.AbstractModule;

class AliasGeneratorModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(NamePool.class).to(SyllablesBasedNamePool.class);

    bind(Syllables.class).to(FileBasedSyllables.class);

  }
}
