package vbir2214MV.controller;

import vbir2214MV.model.Corigent;
import vbir2214MV.model.Elev;
import vbir2214MV.model.Medie;
import vbir2214MV.model.Nota;
import vbir2214MV.repository.*;
import vbir2214MV.utils.ClasaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoteController {
	private NoteRepository note;
	private ClasaRepository clasa;
	private EleviRepository elevi;

	public NoteController() {
		note = new NoteRepositoryMock();
		clasa = new ClasaRepositoryMock();
		elevi = new EleviRepositoryMock();
	}

	public NoteRepository getNoteR()
	{
		return note;
	}

	public void addNota(Nota nota) throws ClasaException {
		note.addNota(nota);
		HashMap<String, List<Double>> materieElev = clasa.getClasa().get(new Elev((int) nota.getNrmatricol(), ""));
		if(materieElev == null)
			throw new ClasaException("Nr matricol incorect");
		if(materieElev.containsKey(nota.getMaterie()))
		{
			List<Double> noteMaterie = materieElev.get(nota.getMaterie());
			noteMaterie.add(nota.getNota());
		}
		else
		{
			List<Double> noteMaterie = new ArrayList<>();
			noteMaterie.add(nota.getNota());
			materieElev.put(nota.getMaterie(), noteMaterie);
		}
	}
	
	public void addElev(Elev elev) {
		elevi.addElev(elev);
	}
	
	public void creeazaClasa(List<Elev> elevi, List<Nota> note) {
		clasa.creazaClasa(elevi, note);
	}
	
	public List<Medie> calculeazaMedii() throws ClasaException {
			return clasa.calculeazaMedii();
		
	}
	
	public List<Nota> getNote() {
		return note.getNote();
	}
	
	public List<Elev> getElevi() {
		return elevi.getElevi();
	}
	
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa() {
		return clasa.getClasa();
	}
	
	public void afiseazaClasa() {
		clasa.afiseazaClasa();
	}
	
	public void readElevi(String fisier) {
		elevi.readElevi(fisier);
	}
	
	public void readNote(String fisier) {
		note.readNote(fisier);
	}
	
	public List<Corigent> getCorigenti() {
		return clasa.getCorigenti();
	}
}
