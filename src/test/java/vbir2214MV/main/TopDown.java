package vbir2214MV.main;

import org.junit.Before;
import org.junit.Test;
import vbir2214MV.controller.NoteController;
import vbir2214MV.model.Corigent;
import vbir2214MV.model.Elev;
import vbir2214MV.model.Medie;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TopDown {
    private NoteController noteController;

    @Before
    public void setUp() {
        noteController = new NoteController();
    }

    @Test
    public void testA() throws ClasaException {
        List<Nota> note = new ArrayList<>();
        note.add(new Nota(1, "Matematica", 7));
        List<Elev> elevi = new ArrayList<>();
        elevi.add(new Elev(1, "Bobita"));
        noteController.creeazaClasa(elevi, note);
        noteController.addNota(new Nota(1, "Matematica", 7));
        assertEquals(1, noteController.getNote().size());
    }

    @Test
    public void testB() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"e1"));
        List<Nota> notaList = new ArrayList<>();
        notaList.add(new Nota(1, "m1",5));
        notaList.add(new Nota(1, "m1",6));
        notaList.add(new Nota(1, "m1",7));
        noteController.creeazaClasa(elevList, notaList);

        List<Medie> medieList = noteController.calculeazaMedii();

        assertEquals(1, medieList.size());
        assertEquals(6, medieList.get(0).getMedie(), 0);
    }

    @Test
    public void testC() {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1, "Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        noteController.creeazaClasa(elevList, notaList);

        List<Corigent> corigenti = noteController.getCorigenti();

        assertEquals(0, corigenti.size());
        assertTrue(corigenti.isEmpty());
    }

    @Test
    public void integration1() throws ClasaException {
        //P->A
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1, "Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        noteController.creeazaClasa(elevList, notaList);
        noteController.addNota(new Nota(1, "materie11", 3));
        noteController.addNota(new Nota(1, "materie11", 4));
        noteController.addNota(new Nota(1, "materie11", 5));
        noteController.addNota(new Nota(2, "materie11", 6));
        noteController.addNota(new Nota(2, "materie11", 2));
        noteController.addNota(new Nota(2, "materie11", 2));
        noteController.addNota(new Nota(3, "materie11", 5));
        noteController.addNota(new Nota(3, "materie11", 4));
        noteController.addNota(new Nota(3, "materie11", 2));

        assertEquals(9, noteController.getNote().size());
    }

    @Test
    public void integration2() throws ClasaException {
        //P->A->B
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1, "Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        noteController.creeazaClasa(elevList, notaList);
        noteController.addNota(new Nota(1, "materie11", 3));
        noteController.addNota(new Nota(1, "materie11", 4));
        noteController.addNota(new Nota(1, "materie11", 5));
        noteController.addNota(new Nota(2, "materie11", 6));
        noteController.addNota(new Nota(2, "materie11", 2));
        noteController.addNota(new Nota(2, "materie11", 2));
        noteController.addNota(new Nota(3, "materie11", 5));
        noteController.addNota(new Nota(3, "materie11", 4));
        noteController.addNota(new Nota(3, "materie11", 2));

        assertEquals(9, noteController.getNote().size());

        List<Medie> medii = noteController.calculeazaMedii();
        assertEquals(3, medii.size());
        assertEquals(4, medii.get(0).getMedie(), 0);
        assertEquals(3.33, medii.get(1).getMedie(), 0.1);
        assertEquals(3.66, medii.get(2).getMedie(), 0.1);
    }

    @Test
    public void integration3() throws ClasaException {
        //P->A->B->C
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        noteController.creeazaClasa(elevList, notaList);
        noteController.addNota(new Nota(1, "materie11",3));
        noteController.addNota(new Nota(1, "materie11",4));
        noteController.addNota(new Nota(1, "materie11",5));
        noteController.addNota(new Nota(2, "materie11",6));
        noteController.addNota(new Nota(2, "materie11",2));
        noteController.addNota(new Nota(2, "materie11",2));
        noteController.addNota(new Nota(3, "materie11",5));
        noteController.addNota(new Nota(3, "materie11",4));
        noteController.addNota(new Nota(3, "materie11",2));

        assertEquals(9, noteController.getNote().size());

        List<Medie> medii = noteController.calculeazaMedii();
        assertEquals(3, medii.size());
        assertEquals(4, medii.get(0).getMedie(), 0);
        assertEquals(3.33, medii.get(1).getMedie(), 0.1);
        assertEquals(3.66, medii.get(2).getMedie(), 0.1);

        List<Corigent> corigenti = noteController.getCorigenti();
        assertEquals(3, corigenti.size());
        assertEquals("Adriana", corigenti.get(0).getNumeElev());
        assertEquals(1, corigenti.get(0).getNrMaterii());
        assertEquals("Andrei", corigenti.get(1).getNumeElev());
        assertEquals(1, corigenti.get(1).getNrMaterii());
        assertEquals("Gigel", corigenti.get(2).getNumeElev());
        assertEquals(1, corigenti.get(2).getNrMaterii());

    }
}