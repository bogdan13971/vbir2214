package vbir2214MV.repository;

import vbir2214MV.model.Corigent;
import vbir2214MV.model.Elev;
import vbir2214MV.model.Medie;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;

import java.util.HashMap;
import java.util.List;

public interface ClasaRepository {
	
	void creazaClasa(List<Elev> elevi, List<Nota> note);
	HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	List<Medie> calculeazaMedii() throws ClasaException;
	void afiseazaClasa();
	List<Corigent> getCorigenti();
}
