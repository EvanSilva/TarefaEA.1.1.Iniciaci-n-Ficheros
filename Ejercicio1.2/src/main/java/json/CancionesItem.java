package json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CancionesItem{

	@JsonProperty("Lista2")
	private List<Lista2Item> lista2;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("Lista1")
	private List<Lista1Item> lista1;

	public List<Lista2Item> getLista2(){
		return lista2;
	}

	public String getNombre(){
		return nombre;
	}

	public List<Lista1Item> getLista1(){
		return lista1;
	}
}