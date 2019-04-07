package vbir2214MV.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import vbir2214MV.model.Elev;
import vbir2214MV.model.Medie;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClasaRepositoryMockTest {
    private ClasaRepository clasaRepository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        clasaRepository = new ClasaRepositoryMock();
    }

    @Test
    public void test1() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        List<Nota> notaList = new ArrayList<>();
        clasaRepository.creazaClasa(elevList, notaList);

        List<Medie> medieList = clasaRepository.calculeazaMedii();

        assertEquals(0, medieList.size());
    }

    @Test
    public void test2() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"e1"));
        elevList.add(new Elev(2,"e2"));
        elevList.add(new Elev(3,"e3"));
        List<Nota> notaList = new ArrayList<>();
        clasaRepository.creazaClasa(elevList, notaList);

        List<Medie> medieList = clasaRepository.calculeazaMedii();

        assertEquals(3, medieList.size());
        assertEquals(Double.NaN, medieList.get(0).getMedie(), 0);
        assertEquals(Double.NaN, medieList.get(1).getMedie(), 0);
        assertEquals(Double.NaN, medieList.get(2).getMedie(), 0);
    }

    @Test
    public void test3() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"e1"));
        List<Nota> notaList = new ArrayList<>();
        notaList.add(new Nota(1, "m1",Double.NaN));
        notaList.add(new Nota(1, "m2",Double.NaN));
        notaList.add(new Nota(1, "m3",Double.NaN));
        clasaRepository.creazaClasa(elevList, notaList);

        List<Medie> medieList = clasaRepository.calculeazaMedii();

        assertEquals(1, medieList.size());
        assertEquals(Double.NaN, medieList.get(0).getMedie(), 0);
    }

    @Test
    public void test4() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"e1"));
        List<Nota> notaList = new ArrayList<>();
        notaList.add(new Nota(1, "m1",5));
        notaList.add(new Nota(1, "m1",6));
        notaList.add(new Nota(1, "m1",7));
        clasaRepository.creazaClasa(elevList, notaList);

        List<Medie> medieList = clasaRepository.calculeazaMedii();

        assertEquals(1, medieList.size());
        assertEquals(6, medieList.get(0).getMedie(), 0);
    }

    @Test
    public void test5() throws ClasaException {
        List<Elev> elevList = new ArrayList<>();
        elevList.add(new Elev(1,"e1"));
        List<Nota> notaList = new ArrayList<>();
        notaList.add(new Nota(1, "m1",5));
        notaList.add(new Nota(1, "m1",6));
        notaList.add(new Nota(1, "m1",7));
        notaList.add(new Nota(1, "m2",Double.NaN));
        clasaRepository.creazaClasa(elevList, notaList);

        List<Medie> medieList = clasaRepository.calculeazaMedii();

        assertEquals(1, medieList.size());
        assertEquals(Double.NaN, medieList.get(0).getMedie(), 0);
    }
}