package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lista1Item{

	@JsonProperty("titulo")
	private String titulo;

	@JsonProperty("duracion")
	private String duracion;

	@JsonProperty("autor")
	private String autor;

	public String getTitulo(){
		return titulo;
	}

	public String getDuracion(){
		return duracion;
	}

	public String getAutor(){
		return autor;
	}
}