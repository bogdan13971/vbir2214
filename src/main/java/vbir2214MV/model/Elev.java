package vbir2214MV.model;

import java.util.Objects;

public class Elev {
	private int nrmatricol;
	private String nume;
	
	public Elev(int nrmatricol, String nume) {
		this.setNrmatricol(nrmatricol);
		this.setNume(nume);
	}

	public int getNrmatricol() {
		return nrmatricol;
	}

	private void setNrmatricol(int nrmatricol) {
		this.nrmatricol = nrmatricol;
	}

	public String getNume() {
		return nume;
	}

	private void setNume(String nume) {
		this.nume = nume;
	}

	public String toString() {
		return this.nrmatricol + " " + this.nume;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Elev elev = (Elev) o;
		return nrmatricol == elev.nrmatricol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nrmatricol);
	}
}
