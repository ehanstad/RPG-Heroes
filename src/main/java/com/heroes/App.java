package com.heroes;

import com.heroes.items.Weapon;
import com.heroes.items.WeaponType;
import com.heroes.rpgHeroes.Mage;

public class App {
    public static void main(String[] args) {
        Mage tyler = new Mage("Tyler the Creator");
        Weapon hugeStaff = new Weapon();
        hugeStaff.type = WeaponType.Staff;
        hugeStaff.name = "Huge damn Staff";
        hugeStaff.damage = 4;
        hugeStaff.requiredLevel = 3;
        tyler.display();
        tyler.levelUp();
        tyler.display();
        tyler.equip(hugeStaff);
        tyler.levelUp();
        tyler.equip(hugeStaff);
        tyler.display();
    }
}
