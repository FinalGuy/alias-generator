[![Build Status](https://travis-ci.org/FinalGuy/alias-generator.svg?branch=master)](https://travis-ci.org/FinalGuy/alias-generator)
[![Maintainability](https://api.codeclimate.com/v1/badges/a99a88d28ad37a79dbf6/maintainability)](https://codeclimate.com/github/codeclimate/codeclimate/maintainability)

# alias-generator

Generates alias name for a given string key.


## Credits
Based on [this post](http://forum.codecall.net/topic/49665-java-random-name-generator/) on codecall.net. 

Kept the logic for concatenation of syllables, but refactored the imperative code into OOP code.

## Usage
You simply obtain an instance of class `AliasGenerator` and call it's public method like this: 

```
AliasGenerator generator = AliasGenerator.newInstance();
String alias = generator.aliasFor("my Key string");

```

For performance reasons i suggest keeping a single instance of the generator because of some I/O operations happening
during initialization.
 
 
