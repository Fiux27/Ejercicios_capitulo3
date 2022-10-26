package Ej3_16;

public class EqualDoublyList {

    public class Nodo {

        
        private Object elemento;
        
        private Nodo anter;
      
        private Nodo next;
        
        public Nodo(Object elemento) {
            this.elemento=elemento;
            this.anter=null;
            this.next=null;
        }

        public Nodo getAnter() {
            return this.anter;
        }


        public Nodo getnext() {
            return this.next;
        }

        public Object get() {
            return this.elemento;
        }
    }

    private Nodo cabeza;
    private Nodo cola;
    private int longitud;

    public int getLongitud() {
        return this.longitud;
    }

    public boolean esVacia() {
        return cabeza==null;
    }

    public void agregaFinal(Object elemento) {
        Nodo n=new Nodo(elemento);
        if (!esVacia()){
          cola.next=n;
          cola.next.anter=cola;
          cola=n;
          longitud++;
        }else{
          cabeza=n;
          cola=n;
          longitud++;
        }
    }

    public void agregaInicio(Object elemento) {
        Nodo n=new Nodo(elemento);
        if (!esVacia()){
          cabeza.anter=n;
          cabeza.anter.next=cabeza;
          cabeza=n;
          longitud++;
        }else{
          cabeza=n;
          cola=n;
          longitud++;
        }
    }

    public void inserta(int i, Object elemento) {
        Nodo n= new Nodo(elemento);
        if (i<=0){
            agregaInicio(elemento);
        }else if (i>=getLongitud()){
            agregaFinal(elemento);
        }else if(getLongitud()==0){
            cabeza=n;
            cola=n;
            longitud++;
        }else{
          int cont=0;
          Nodo aux=cabeza;
          while(cont<i){
            aux=aux.next;
            cont++;
          }
          aux.anter.next=n;
          aux.anter=n;
          n.next=aux;
          n.anter=aux.anter.anter;
          longitud++;
        }

    }

    public void elimina(Object elemento) {
        if(!esVacia() && contiene(elemento)){
          if(cabeza.next==null){
            cabeza=null;
            cola=null;
            longitud--;
          }else{
            Nodo n=cabeza;
            while(n.next!=null && !n.get().equals(elemento)){
              n=n.next;
            }
            if(n.anter==null){
              eliminaPrimero();
            }else if (n.next==null){
              eliminaUltimo();
            }else{
              n.next.anter=n.anter;
              n.anter.next=n.next;
              n.next=null;
              n.anter=null;
              longitud--;
            }
          }
        }
    }

    public Object eliminaPrimero() {
        if(!esVacia()){
          Nodo n=cabeza;
          if(cabeza.next==null){
            cabeza=null;
            cola=null;
          }else{
            cabeza=cabeza.next;
            cabeza.anter.next=null;
            cabeza.anter=null;
          }
          longitud--;
          return n.get();
        }
        return null;
    }

    public Object eliminaUltimo() {
        if(!esVacia()){
          Nodo n=cola;
          if(cola.anter==null){
            cabeza=null;
            cola=null;
          }else{
            cola=cola.anter;
            cola.next.anter=null;
            cola.next=null;
          }
          longitud--;
          return n.get();
        }
        return null;
    }

    public boolean contiene(Object elemento) {
        Nodo aux=cabeza;
        for (int i=1;i<=getLongitud();i++){
          if(aux.get().equals(elemento)){
            return true;
          }
          aux=aux.next;
        }
        return false;
    }

    public EqualDoublyList reversa() {
        EqualDoublyList rev=new EqualDoublyList();
        Nodo n=cola;
        for(int i=1;i<=getLongitud();i++){
          rev.agregaFinal(n.get());
          n=n.anter;
        }
        return rev;
    }

    public EqualDoublyList copia() {
        EqualDoublyList l=new EqualDoublyList();
        Nodo n=cabeza;
        for(int i=1;i<=getLongitud();i++){
          l.agregaFinal(n.get());
          n=n.next;
        }
        return l;
    }

    public void limpia() {
        Nodo n=cabeza;
        while(getLongitud()!=0){
          eliminaPrimero();
        }
    }

    public Object getPrimero() {
        if(!esVacia()){
          return cabeza.get();
        }
        return null;
    }

    public Object getUltimo() {
        if(!esVacia()){
          return cola.get();
        }
        return null;
    }

    public Object get(int i) {
        if(0<=i && i<getLongitud()){
          Nodo n=cabeza;
          int cont=0;
          while(n.next!=null && cont<i){
            n=n.next;
            cont++;
          }
          return n.get();
        }
        return null;
    }

    public int indiceDe(Object elemento) {
        if(contiene(elemento)){
          int contador=0;
          Nodo aux=cabeza;
          while(!aux.get().equals(elemento)){
            aux=aux.next;
            contador++;
          }
          return contador;
        }
        return -1;
    }

    @Override public String toString() {
        if (getLongitud()==0){
          return "[]";
        }
        String s = "[";
        for (int i = 0; i < getLongitud()-1; i++)
            s += String.format("%s, ", (String)get(i));
        s += String.format("%s]", (String)get(getLongitud()-1));
        return s;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof EqualDoublyList))
            return false;
            EqualDoublyList lista = (EqualDoublyList)o;
        if(getLongitud()!=lista.getLongitud())
            return false;
        Nodo aux1=this.cabeza;
        Nodo aux2=lista.cabeza;
        for(int i=0;i<getLongitud();i++){
            if(!aux1.get().equals(aux2.get()))
                return false;
            aux1=aux1.next;
            aux2=aux2.next;
        }
        return true;
    }

    public Nodo getCabeza() {
        return this.cabeza;
    }

    public Nodo getRabo() {
        return this.cola;
    }
}
