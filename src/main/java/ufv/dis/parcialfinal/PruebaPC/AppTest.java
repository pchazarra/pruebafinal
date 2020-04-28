package ufv.dis.parcialfinal.PruebaPC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AppTest {
	Lista l = new Lista();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 

	@Test
	public void creacionUsuario() {
		Usuario u = new Usuario("Pedro", "Chazarra", 18);
		l.addUsuario(u);
		assertEquals("Pedro", u.getNombre());
	}
	
	@Test
	public void insertUsuario() {
		Usuario u = new Usuario("Pedro", "Chazarra", 18);
		l.addUsuario(u);
		usuarios = l.getUsuarios();
		assertEquals(1, usuarios.size());
	}
	
	@Test
	public void mayoriaEdad() {
		Usuario u = new Usuario("Pedro", "Chazarra", 18);
		assertTrue(u.isAdult(u));
	}
	
	@Test
	public void mayoriaEdad_not() {
		Usuario u = new Usuario("Pedro", "Chazarra", 17);
		assertFalse(u.isAdult(u));
	}
	
	
}
