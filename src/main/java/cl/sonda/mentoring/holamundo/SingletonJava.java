package cl.sonda.mentoring.holamundo;

public class SingletonJava {
    
    private static SingletonJava instancia;

    private SingletonJava(){

    }

    public static SingletonJava getInstancia(){
        if (instancia == null){
            instancia = new SingletonJava();
        }
        return instancia;
    }
    
}
