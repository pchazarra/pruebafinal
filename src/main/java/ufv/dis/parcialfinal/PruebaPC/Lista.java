package ufv.dis.parcialfinal.PruebaPC;

import java.util.ArrayList;

public class Lista {
	
	private ArrayList<Usuario> usuarios;
	
	public Lista() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public void addUsuario (Usuario u) {
		usuarios.add(u);
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
}
