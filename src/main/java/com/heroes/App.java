package com.heroes;

import com.heroes.game.Game;

/**
 * This is the main class. It is from here the game is started
 */
public class App {
    public static void main(String[] args) {
        while (true)
            Game.startGame();
    }
}
