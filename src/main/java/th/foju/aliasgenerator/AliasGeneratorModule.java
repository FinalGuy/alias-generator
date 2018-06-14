package th.foju.aliasgenerator;

import com.google.inject.AbstractModule;
import th.foju.aliasgenerator.syllables.SyllablesBasedNamePool;

class AliasGeneratorModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(NamePool.class).to(SyllablesBasedNamePool.class);

  }
}
