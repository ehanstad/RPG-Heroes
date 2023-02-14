package com.heroes.rpgHeroes;

/**
 * This class is an instance of a heros attribute, it includes the heros
 * strength, dexterity and intelligence.
 */
public class HeroAttribute {
  private int strength;
  private int dexterity;
  private int intelligence;

  public HeroAttribute(int strength, int dexterity, int intelligence) {
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }

  /**
   * Increases the heros attributes by adding the incoming attributes
   * with existing attributes
   * 
   * @param strength     the strength which will be added
   * @param dexterity    the dexterity which will be added
   * @param intelligence the intelligence which will be added
   */
  public void increaseAttribute(int strength, int dexterity, int intelligence) {
    this.strength += strength;
    this.dexterity += dexterity;
    this.intelligence += intelligence;
  }

  public int getTotal() {
    return this.strength + this.dexterity + this.intelligence;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getDexterity() {
    return this.dexterity;
  }

  public int getIntelligence() {
    return this.intelligence;
  }
}
