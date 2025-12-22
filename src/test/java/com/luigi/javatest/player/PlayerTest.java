package com.luigi.javatest.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void looses_when_dice_number_is_too_low() {
        // Simulamos un dado que siempre saca 2
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        // El jugador necesita sacar al menos 3 para ganar
        Player player = new Player(dice, 3);
        assertFalse(player.play(), "El jugador debería perder si el dado saca 2 y el mínimo es 3");
    }

    @Test
    public void wins_when_dice_number_is_big() {
        // Simulamos un dado que siempre saca 4
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        // El jugador necesita sacar al menos 3 para ganar
        Player player = new Player(dice, 3);
        assertTrue(player.play(), "El jugador debería ganar si el dado saca 4 y el mínimo es 3");
    }
}