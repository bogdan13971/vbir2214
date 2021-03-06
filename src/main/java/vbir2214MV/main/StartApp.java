package vbir2214MV.main;

import vbir2214MV.controller.NoteController;
import vbir2214MV.model.Corigent;
import vbir2214MV.model.Medie;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//functionalitati
//F01.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata);
//F02.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol),
//F03.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat şi alfabetic dupa nume.

public class StartApp {

	/**
	 * @param args
	 * @throws ClasaException
	 */
	public static void main(String[] args) throws ClasaException {
		// TODO Auto-generated method stub

		if(args[0] == null || args[1] == null)
			throw new ClasaException("Incorrect parameters");

		NoteController ctrl = new NoteController();
		List<Medie> medii;
		List<Corigent> corigenti;
		ctrl.readElevi(args[0]);
		ctrl.readNote(args[1]);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		boolean gasit = false;
		while (!gasit) {
			System.out.println("1. Adaugare Nota");
			System.out.println("2. Calculeaza medii");
			System.out.println("3. Elevi corigenti");
			System.out.println("4. Afiseaza clasa");
			System.out.println("5. Iesire");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int option = Integer.parseInt(br.readLine());
				switch (option) {
					case 1:
						System.out.println("Nr matricol : ");
						int nrMatricol = Integer.parseInt(br.readLine());
						System.out.println("Materie : ");
						String materie = br.readLine();
						System.out.println("Nota : ");
						int nota = Integer.parseInt(br.readLine());
						Nota n2 = new Nota(nrMatricol, materie, nota);
						ctrl.addNota(n2);
						ctrl.getNoteR().saveNota(n2, args[1]);
					case 2:
						medii = ctrl.calculeazaMedii();
						for (Medie medie : medii)
							System.out.println(medie);
						break;
					case 3:
						corigenti = ctrl.getCorigenti();
						for (Corigent corigent : corigenti)
							System.out.println(corigent);
						break;
					case 4:
						System.out.println("Clasa : ");
						ctrl.afiseazaClasa();
						break;
					case 5:
						gasit = true;
						break;
					default:
						System.out.println("Introduceti o optiune valida!");
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
