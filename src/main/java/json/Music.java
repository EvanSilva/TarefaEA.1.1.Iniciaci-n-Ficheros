package json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Music{

	@JsonProperty("Canciones")
	private List<CancionesItem> canciones;

	public List<CancionesItem> getCanciones(){
		return canciones;
	}
}