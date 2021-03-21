package p5dgm.main;

import java.util.ArrayList;
import java.util.List;

public class ListaProyecto {

	public List<Proyecto> list;

    public ListaProyecto(){
        list = new ArrayList<Proyecto>();
    }

    public void add(Proyecto p){
        list.add(p);
    }

}
