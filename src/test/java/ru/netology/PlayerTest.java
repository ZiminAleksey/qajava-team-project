package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Игра 2", "Гонки");
        Game game3 = store.publishGame("Игра 3", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }


    @Test
    public void TestSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("PUBG", "BattleRoyale");
        Game game1 = store.publishGame("Fortnite", "BattleRoyale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);

        int expected = 5;
        int actual = player.sumGenre("BattleRoyale");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("PUBG", "BattleRoyale");
        Game game1 = store.publishGame("Fortnite", "BattleRoyale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 1);

        });
    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("PUBG", "BattleRoyale");
        Game game1 = store.publishGame("Fortnite", "BattleRoyale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);

        Game expected = game;
        Game actual = player.mostPlayerByGenre("BattleRoyale");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreNoInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("PUBG", "BattleRoyale");
        Game game1 = store.publishGame("Fortnite", "BattleRoyale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 2);


        String expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void addPlayGameNegativeValue() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        
        assertThrows(Exception.class, () -> {
            player.play(game, -1);
        });
    }

    @Test
    public void addDoubleGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("PUBG", "BattleRoyale");
        Game game1 = store.publishGame("Fortnite", "BattleRoyale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game);

        int expected = 1;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


}
