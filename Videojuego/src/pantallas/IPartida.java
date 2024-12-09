package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import entidad.GestorInterraccionesJugadores;
import entidad.Jugador1;
import entidad.Jugador2;
import entidad.MovimientoJugador;
import entidad.MovimientoJugador2;
import pantallas.Controlador.CHOICEP1;
import pantallas.Controlador.CHOICEP2;
/*
 * Interfaz de la clase Partida que va a cumplir las funciones de inicializar una partida y de terminarla*/
public interface IPartida {
	void empezarPartida();
	void terminarPartida();
}


