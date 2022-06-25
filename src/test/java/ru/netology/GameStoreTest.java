package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//        Game game1 = store.publishGame("Нетология Баттл Онлайн2", "Аркады2");
//        boolean containsGame = store.containsGame(game1);

        GameStore store1 = new GameStore();
        Game game11 = store1.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game122 = store1.publishGame("Нетология Баттл Онлайн2", "Аркады2");
        boolean containsGame = store1.containsGame(game11);
        assertTrue(store1.containsGame(game122));
    }

    @Test
    public void shouldPlayTime() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн 1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 1);
        store.addPlayTime("Anna", 1);
        store.getMostPlayer();

        GameStore store1 = new GameStore();

        Game game3 = store1.publishGame("Уличный стрит", "Гонки");
        Game game4 = store1.publishGame("Сматываемся от полицейских", "Гонки");
        store1.addPlayTime("Petya", 3);
        store1.addPlayTime("Anton", 1);
        store1.addPlayTime("Lexx", 5);
        store1.addPlayTime("Petya", 4);
        store1.getMostPlayer();



    }


}
