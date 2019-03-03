import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class FactoryCartas<E> {


    public Map getImplementacion(String opc){

        if (opc.equals("1")) {
            return new HashMap();
    }
        else if (opc.equals("2")){
            return new TreeMap();
        }
        else if (opc.equals("3")){
            return new LinkedHashMap();
        }
        else
        return new HashMap();
    }
}