package util;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;
import modelo.Student;

/**
 *
 * @author Toloza XD
 */
public class SimuladorArbolBinario<T extends Comparable<T>> {

    ArbolBinario miArbol = new ArbolBinario();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(T dato) {
        return (this.miArbol.agregar(dato));
    }
    
    public boolean eliminar(T dato) {
        return (this.miArbol.eliminar(dato));
    }

    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorridoCodigoEstudiantes(it, "Recorrido PreOrden"));
//        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorridoCodigoEstudiantes(it, "Recorrido InOrden"));
//        return (recorrido(it, "Recorrido InOrden"));
    }

    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorridoCodigoEstudiantes(it, "Recorrido PosOrden"));
//        return (recorrido(it, "Recorrido PosOrden"));
    }

    //metodo para poder mostrar los tipos d recorrido
//    private String recorrido(LinkedList it, String msg) {
//        int i = 0;
//        String r = msg + "\n";
//        while (i < it.size()) {
//            r += "\t" + it.get(i).toString() + "";
//            i++;
//        }
//        return (r);
//    }
    private String recorridoCodigoEstudiantes(LinkedList it, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg).append("\n");

        for (Object item : it) {
            if (item instanceof Student) {
                Student estudiante = (Student) item;
                sb.append("\t").append(estudiante.getCode()).append("\n");
            }
        }

        return sb.toString();
    }

    //Metodo para buscar dato en el nodo
    public String buscar(T dato) {
        boolean siEsta = this.miArbol.existe2(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
