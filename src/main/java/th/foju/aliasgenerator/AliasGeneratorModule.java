package th.foju.aliasgenerator;

import com.google.inject.AbstractModule;
import th.foju.aliasgenerator.syllables.SyllablesBasedNames;

class AliasGeneratorModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(NamePool.class).to(SyllablesBasedNames.class);

  }
}
