package vbir2214MV.repository;

import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;

import java.util.List;

public interface NoteRepository {
	
	void addNota(Nota nota) throws ClasaException;
	List<Nota> getNote();
	void readNote(String fisier);
	void saveNota(Nota nota, String fisier);
}
