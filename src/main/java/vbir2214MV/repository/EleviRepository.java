package vbir2214MV.repository;

import vbir2214MV.model.Elev;
import java.util.List;

public interface EleviRepository {
	void addElev(Elev e);
	List<Elev> getElevi();
	void readElevi(String fisier);
}
