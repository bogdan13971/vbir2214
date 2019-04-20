package vbir2214MV.repository;

import org.junit.Before;
import org.junit.Test;
import vbir2214MV.model.Corigent;
import vbir2214MV.model.Elev;
import vbir2214MV.model.Nota;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClasaRepositoryMockTest2 {
    private ClasaRepository clasaRepository;

    @Before
    public void setUp() {
        clasaRepository = new ClasaRepositoryMock();
    }

    @Test
    public void test1()
    {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        notaList.add(new Nota(1, "m1",3));
        notaList.add(new Nota(1, "m1",4));
        notaList.add(new Nota(1, "m1",5));
        notaList.add(new Nota(2, "m1",6));
        notaList.add(new Nota(2, "m1",2));
        notaList.add(new Nota(2, "m1",2));
        notaList.add(new Nota(3, "m1",5));
        notaList.add(new Nota(3, "m1",4));
        notaList.add(new Nota(3, "m1",2));
        notaList.add(new Nota(3, "m2",5));
        notaList.add(new Nota(3, "m2",4));
        notaList.add(new Nota(3, "m2",2));
        clasaRepository.creazaClasa(elevList, notaList);

        List<Corigent> corigenti = clasaRepository.getCorigenti();

        assertEquals(3, corigenti.size());
        assertEquals("Adriana", corigenti.get(0).getNumeElev());
        assertEquals(2, corigenti.get(0).getNrMaterii());
        assertEquals("Andrei", corigenti.get(1).getNumeElev());
        assertEquals(1, corigenti.get(1).getNrMaterii());
        assertEquals("Gigel", corigenti.get(2).getNumeElev());
        assertEquals(1, corigenti.get(2).getNrMaterii());
    }

    @Test
    public void test2()
    {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1, "Gigel"));
        elevList.add(new Elev(2, "Andrei"));
        elevList.add(new Elev(3, "Adriana"));
        List<Nota> notaList = new ArrayList<>();
        clasaRepository.creazaClasa(elevList, notaList);

        List<Corigent> corigenti = clasaRepository.getCorigenti();

        assertEquals(0, corigenti.size());
        assertTrue(corigenti.isEmpty());
    }

}