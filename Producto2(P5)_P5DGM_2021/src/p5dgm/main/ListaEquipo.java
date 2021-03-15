package p5dgm.main;

import java.util.ArrayList;
import java.util.List;

public class ListaEquipo {

	    public List<Equipo> list;

	    public ListaEquipo(){
	        list = new ArrayList<Equipo>();
	    }

	    public void add(Equipo p){
	        list.add(p);
	    }
}
