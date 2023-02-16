# RPG Heroes
This is a Maven project written in Java.

## Features

### model
The main focus of the project is the model part; found in /items, /rpgHeros. `Hero.java` is a abstract class inits, the name, level, empty slots and defines methods the different hero-classes - /classes. Inside it is also one class `Util`, a kind of help class for the sub-classes. 

`items` is also abstract class containing of a name, a required level a hero needs to equip that item and a slot spot. There are two different kinds of items `Weapons` and `Armor`. Weapons differs in the way that it has a `WeaponType` - a enum with values of different weapon types - and a damage value which adds to the heros damage. Armor has instead of WeaponType a ArmorType which as you can guess is a enum with values of different armor types, and a armor attribute. Armor attribute is of type `HeroAttribute` - contains fields of strength, dexterity and intelligence.

/exceptions contains two kinds of custom exceptions, thrown if armor or weapon is tried to equip when either the the class is wrong for the hero or the heros level is to low.

### view
The actual game is created in /game, containing of `Game` which inits the game with input from the user. `FirstSection` and `SecondSection` is classes which takes the game forward. `GameUtils` is a help-class for the earlier mentioned classes. `ConsoleColor` is a class which contains ANSI code for different colors for the console. 

### tests
Most of the functions in model are tested, those tests can be found in the /test folder where tests are created for each specific classes together with Armor and Weapon classes.

## Description
First assignment for the backend part of the course Java Fullstack Remote Nordics Jan 23

### Author
Erik Hanstad