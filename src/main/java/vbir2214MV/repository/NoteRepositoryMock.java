package vbir2214MV.repository;

import org.apache.commons.lang3.math.NumberUtils;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;
import vbir2214MV.utils.Constants;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class NoteRepositoryMock implements NoteRepository{
	private List<Nota> note;
	
	public NoteRepositoryMock() {
		note = new LinkedList<>();
	}

	@Override
	public void addNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(!validareNota(nota))
			return;
		note.add(nota);
	}

	public void saveNota(Nota nota, String filename){
		try {
			FileOutputStream fstream = new FileOutputStream(filename, true);
			DataOutputStream out = new DataOutputStream(fstream);
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(out));
			String line = nota.getNrmatricol() + ";" + nota.getMaterie() + ";" + nota.getNota() +"\n";
			br.write(line);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean validareNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(NumberUtils.isNumber(nota.getMaterie()))
			throw new ClasaException(Constants.invalidMaterie);
		if(nota.getMaterie().length() < 5 || nota.getMaterie().length() > 20)
			throw new ClasaException(Constants.invalidMateria);
		if(nota.getNrmatricol() < Constants.minNrmatricol || nota.getNrmatricol() > Constants.maxNrmatricol)
			throw new ClasaException(Constants.invalidNrmatricol);
		if(nota.getNota() < Constants.minNota || nota.getNota() > Constants.maxNota)
			throw new ClasaException(Constants.invalidNota);
		if(nota.getNota() != (int)nota.getNota())
			throw new ClasaException(Constants.invalidNota);
		if(nota.getNrmatricol() != nota.getNrmatricol())
			throw new ClasaException(Constants.invalidNrmatricol);
		return true;
	}

	@Override
	public List<Nota> getNote() {
		// TODO Auto-generated method stub
		return note;
	}
	
	public void readNote(String fisier) {
		try {
			FileInputStream fstream = new FileInputStream(fisier);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Nota nota = new Nota(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]));
				note.add(nota);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
