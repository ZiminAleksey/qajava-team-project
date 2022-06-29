package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameStoreTest {


    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Cup Head", "Платформер");
        Game game2 = store.publishGame("Cup Head", "Платформер");


        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldPlayTime() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн 1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 1);
        store.addPlayTime("Anna", 1);

        String expected = store.getMostPlayer();
        String actual = "Petya";
        assertEquals(expected, actual);
    }


    @Test
    public void shouldSumTimePetya() {
        GameStore store1 = new GameStore();

        Game game3 = store1.publishGame("Уличный стрит", "Гонки");
        Game game4 = store1.publishGame("Сматываемся от полицейских", "Гонки");
        store1.addPlayTime("Petya", 3);
        store1.addPlayTime("Anton", 1);
        store1.addPlayTime("Lexx", 5);
        store1.addPlayTime("Petya", 4);
        store1.getMostPlayer();

        String actual = store1.getMostPlayer();
        String expected = "Petya";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumTimePlayers() {
        GameStore store1 = new GameStore();

        Game game3 = store1.publishGame("Уличный стрит", "Гонки");
        Game game4 = store1.publishGame("Сматываемся от полицейских", "Гонки");
        store1.addPlayTime("Petya", 3);
        store1.addPlayTime("Anton", 1);
        store1.addPlayTime("Lexx", 5);
        store1.getSumPlayedTime();

        int actual = store1.getSumPlayedTime();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseContainsGame() {
        GameStore store = new GameStore();
        GameStore store1 = new GameStore();

        Game game1 = store.publishGame("Уличный стрит", "Гонки");
        Game game2 = store1.publishGame("Сматываемся от полицейских", "Гонки");

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void addDoubleGames() {
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Уличный стрит", "Гонки");
        assertThrows(RuntimeException.class, () -> {
            store.publishGame("Уличный стрит", "Гонки");
        });
    }

    @Test
    public void addNegativePlayTime() {
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Уличный стрит", "Гонки");
        Game game2 = store.publishGame("Сматываемся от полицейских", "Гонки");
        Game game3 = store.publishGame("Cup Head", "Платформер");

        store.addPlayTime("Petya", 3);
        store.addPlayTime("Anton", 1);
        store.addPlayTime("Lexx", 5);
        store.addPlayTime("Petya", -4);
        store.getMostPlayer();

        String actual = store.getMostPlayer();
        String expected = "Petya";

        assertEquals(expected, actual);
    }

}

