package com.aedi.ejercicios.rankingJugadores;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método insertarOrdenado de RankingJugadores.
 */
public class RankingJugadoresTest {

    // ── Tests de inserción ordenada ────────────────────────────────────

    @Test
    public void testInsertarEnRankingVacio() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("xShadow", 9500);

        assertEquals(1, ranking.getSize());
        assertEquals("xShadow", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals(9500, ranking.getNodoEnPosicion(0).getPuntuacion());
    }

    @Test
    public void testInsertarMenorPuntuacion() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("xShadow", 9500);
        ranking.insertarOrdenado("StarDust", 4100);

        assertEquals(2, ranking.getSize());
        assertEquals("xShadow", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals("StarDust", ranking.getNodoEnPosicion(1).getGamertag());
    }

    @Test
    public void testInsertarMayorPuntuacion() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("StarDust", 4100);
        ranking.insertarOrdenado("xShadow", 9500);

        assertEquals(2, ranking.getSize());
        assertEquals("xShadow", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals("StarDust", ranking.getNodoEnPosicion(1).getGamertag());
    }

    @Test
    public void testInsertarEnMedio() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("xShadow", 9500);
        ranking.insertarOrdenado("StarDust", 4100);
        ranking.insertarOrdenado("NeonByte", 7200);

        assertEquals(3, ranking.getSize());
        assertEquals("xShadow", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals(9500, ranking.getNodoEnPosicion(0).getPuntuacion());
        assertEquals("NeonByte", ranking.getNodoEnPosicion(1).getGamertag());
        assertEquals(7200, ranking.getNodoEnPosicion(1).getPuntuacion());
        assertEquals("StarDust", ranking.getNodoEnPosicion(2).getGamertag());
        assertEquals(4100, ranking.getNodoEnPosicion(2).getPuntuacion());
    }

    @Test
    public void testInsertarConEmpate() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("A", 100);
        ranking.insertarOrdenado("B", 100);
        ranking.insertarOrdenado("C", 100);

        assertEquals(3, ranking.getSize());
        // En empate, se mantiene el orden de llegada
        assertEquals("A", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals("B", ranking.getNodoEnPosicion(1).getGamertag());
        assertEquals("C", ranking.getNodoEnPosicion(2).getGamertag());
    }

    @Test
    public void testInsertarConEmpateEnMedio() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("A", 500);
        ranking.insertarOrdenado("B", 300);
        ranking.insertarOrdenado("C", 100);
        ranking.insertarOrdenado("D", 300); // Empata con B

        assertEquals(4, ranking.getSize());
        assertEquals("A", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals("B", ranking.getNodoEnPosicion(1).getGamertag());
        assertEquals("D", ranking.getNodoEnPosicion(2).getGamertag()); // Después de B
        assertEquals("C", ranking.getNodoEnPosicion(3).getGamertag());
    }

    @Test
    public void testInsertarMayorQueTodasAlPrincipio() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("A", 500);
        ranking.insertarOrdenado("B", 300);
        ranking.insertarOrdenado("C", 100);
        ranking.insertarOrdenado("D", 800);

        assertEquals(4, ranking.getSize());
        assertEquals("D", ranking.getNodoEnPosicion(0).getGamertag());
        assertEquals(800, ranking.getNodoEnPosicion(0).getPuntuacion());
    }

    @Test
    public void testInsertarMenorQueTodasAlFinal() {
        RankingJugadores ranking = new RankingJugadores();
        ranking.insertarOrdenado("A", 500);
        ranking.insertarOrdenado("B", 300);
        ranking.insertarOrdenado("C", 50);

        assertEquals(3, ranking.getSize());
        assertEquals("C", ranking.getNodoEnPosicion(2).getGamertag());
        assertEquals(50, ranking.getNodoEnPosicion(2).getPuntuacion());
        // Verificar que el último apunta al trailer
        assertSame(ranking.getTrailer(), ranking.getNodoEnPosicion(2).getNext());
    }

    @Test
    public void testInsertarMantieneCentinelas() {
        RankingJugadores ranking = new RankingJugadores();
        NodoJugador headerOriginal = ranking.getHeader();
        NodoJugador trailerOriginal = ranking.getTrailer();

        ranking.insertarOrdenado("A", 500);
        ranking.insertarOrdenado("B", 300);
        ranking.insertarOrdenado("C", 800);

        assertSame(headerOriginal, ranking.getHeader());
        assertSame(trailerOriginal, ranking.getTrailer());
    }

    // ── Tests del tamaño ────────────────────────────────────────────────

    @Test
    public void testSizeSeIncrementaCorrectamente() {
        RankingJugadores ranking = new RankingJugadores();
        assertEquals(0, ranking.getSize());

        ranking.insertarOrdenado("A", 500);
        assertEquals(1, ranking.getSize());

        ranking.insertarOrdenado("B", 300);
        assertEquals(2, ranking.getSize());

        ranking.insertarOrdenado("C", 800);
        assertEquals(3, ranking.getSize());

        ranking.insertarOrdenado("D", 300);
        assertEquals(4, ranking.getSize());
    }
}
