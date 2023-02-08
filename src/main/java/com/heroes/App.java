package com.heroes;

import com.heroes.items.Weapon;
import com.heroes.items.types.WeaponType;
import com.heroes.rpgHeroes.classes.Mage;
import com.heroes.rpgHeroes.classes.Ranger;
import com.heroes.rpgHeroes.classes.Rogue;
import com.heroes.rpgHeroes.classes.Warrior;

public class App {
    public static void main(String[] args) {
        Mage tyler = new Mage("Tyler the Creator");
        Ranger vince = new Ranger("Vince Staples");
        Rogue mac = new Rogue("Mac Miller");
        Warrior kDot = new Warrior("Kendrick Lamar");

        Weapon hugeStaff = new Weapon("Huge damn Staff", 3, WeaponType.Staff, 4);
        Weapon wand = new Weapon("Hocus Pocus", 2, WeaponType.Wand, 2);

        tyler.display();
        tyler.levelUp();
        tyler.display();
        tyler.equip(hugeStaff);
        tyler.levelUp();
        tyler.equip(hugeStaff);
        tyler.display();

        vince.display();
        vince.levelUp();
        vince.levelUp();
        vince.equip(hugeStaff);
        vince.levelUp();
        vince.display();
    }
}
