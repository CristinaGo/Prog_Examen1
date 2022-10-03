package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Videojuego v = new Videojuego(1,"s","d","e","f",5.00,true,2);

        VideojuegoDAO.create(v);
    }
}
