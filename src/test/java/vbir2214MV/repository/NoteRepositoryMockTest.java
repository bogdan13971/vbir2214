package vbir2214MV.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import vbir2214MV.model.Nota;
import vbir2214MV.utils.ClasaException;
import vbir2214MV.utils.Constants;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class NoteRepositoryMockTest {
    private NoteRepository noteRepository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        noteRepository = new NoteRepositoryMock();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ec1() throws ClasaException {
        Nota nota = new Nota(1, "Matematica", 7);
        noteRepository.addNota(nota);
        assertEquals(1, noteRepository.getNote().size());
    }

    @Test
    public void ec2() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMaterie);
        Nota nota = new Nota(2, "893", 10);
        noteRepository.addNota(nota);
    }

    @Test
    public void ec3() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(3, "Romana", -23);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva1() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(1, "", 4);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva2() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(2, "a", 5);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva3() throws ClasaException {
        Nota nota = new Nota(3, "abcdef", 8);
        noteRepository.addNota(nota);
        assertEquals(1, noteRepository.getNote().size());
    }

    @Test
    public void bva4() throws ClasaException {
        Nota nota = new Nota(4, "abcdef89ghskef83jk23", 9);
        noteRepository.addNota(nota);
        assertEquals(1, noteRepository.getNote().size());
    }

    @Test
    public void bva5() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(5, "aWpflKCIhBotaooYEgLE7Mp0q2XtWrAsZl3XpCSQptR4h8DYR33kSicw89zWcqjsnZtmkUiBvHsZv3F4Kc3b5adixCcDAOkl246ML4tv3RmLvmulq7aNt612", 5);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva6() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(6, "aKHSPPsy8vasy3Gm2Hr1n9I8v4yiWqweXSX3lEslW2ixxZ9mDCz4q4gzbsCm0F7sDyiuFHClTbQCzv1xafy9Uh4sXaN1EU7V5YF7XdUcWhULpHwsEaN1UFgXBOkJ6gpxwyVKyeyEi7l3emVNR0Og76CDLstKEOWIaGuYD8Gan0DaYoT5ka02aNqLwy2hl5MSGJh5vy1zlrqJuhooiECo2PebBBQli94ce6AG7BPlEhkx5gzLfdZeeIDxtY1234", 4);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva7() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(7, "romana", -12);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva8() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(8, "romana", 0);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva9() throws ClasaException {
        Nota nota = new Nota(9, "romana", 5);
        noteRepository.addNota(nota);
        assertEquals(1, noteRepository.getNote().size());
    }

    @Test
    public void bva10() throws ClasaException {
        Nota nota = new Nota(10, "romana", 8);
        noteRepository.addNota(nota);
        assertEquals(1, noteRepository.getNote().size());
    }

    @Test
    public void bva11() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(11, "romana", 11);
        noteRepository.addNota(nota);
    }

    @Test
    public void bva12() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(11, "romana", 92);
        noteRepository.addNota(nota);
    }
}