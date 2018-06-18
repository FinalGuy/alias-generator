[![Build Status](https://travis-ci.org/FinalGuy/alias-generator.svg?branch=master)](https://travis-ci.org/FinalGuy/alias-generator)
[![Maintainability](https://api.codeclimate.com/v1/badges/1384afb8356ab0a9d69d/maintainability)](https://codeclimate.com/github/FinalGuy/alias-generator/maintainability)

# alias-generator

Generates alias name for a given string key.


## Credits
Based on [this post](http://forum.codecall.net/topic/49665-java-random-name-generator/) on codecall.net. 

Kept the logic for concatenation of syllables, but refactored the imperative code into OOP code.

## Usage
You just have to instantiate an `AliasGeneratorConfig` and obtain an instance of class `AliasGenerator`. After that 
you can start by calling it's public method like this: 

```
AliasGeneratorConfig config = new AliasGeneratorConfig();
AliasGenerator generator = config.newInstance();
String alias = generator.aliasFor("my Key string");

```

 
 
