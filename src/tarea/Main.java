package tarea;

import tarea.entities.pikachu.pikachu;

import java.io.IOException;
import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) throws IOException {
        pikachu pikachu1 = new pikachu(7, "Pikachu 1", "tipo", 5, 1);
        pikachu pikachu2 = new pikachu(7, "Pikachu 2", "tipo", 5, 1);
        int turno = 0;
        int opcion = 0;

        out.println(ANSI_CYAN + "--- Bienvenido a Pokemon Ultra 2021 Batalla de Pikachus---");
        out.println(" Hay 5 Reglas");
        out.println("1-Cada Pokemon tiene 7 puntos de vida e inicia en nivel 1.");
        out.println("2-Un pokemon puede curarse, subir de nivel o atacar");
        out.println("3-Al subir de nivel se sube en 1");
        out.println("4-Al atacar o curarse se cura o ataca por el nivel que tenga el pokemon");
        out.println("5-Gana el primero que disminuya los puntos de vida del enemigo a 0"+ANSI_RESET);

        out.println(ANSI_GREEN + "Cambiar nombre a Pikachu 1");
        out.println("Nuevo nombre del pikachu: ");
        String nombre = in.readLine();
        pikachu1.setNombre(nombre);

        out.println(ANSI_BLUE + "Cambiar nombre a Pikachu 2");
        out.println("Nuevo nombre del pikachu: ");
        nombre = in.readLine();
        pikachu2.setNombre(nombre);

        do {
            out.println(ANSI_CYAN + "        ");
            out.println("--- Turno " + turno + " ---");
            if (turno == 0) {
                printStatus(pikachu1);
                printStatus(pikachu2);
                out.println("---- --- --- --- --- ----");
                out.println("        ");
                out.println("        ");
            }
            opcion = printMenu1();
            switch (opcion) {
                case 1:
                    out.println("Curando...");
                    pikachu1.curar();
                    break;
                case 2:
                    out.println(pikachu1.getNombre() + " ha subido de nivel!");
                    pikachu1.subirNivel();
                    break;
                case 3:
                    out.println(pikachu1.getNombre() + " ha usado un IMPACTRUENO!");
                    pikachu2.hit(pikachu1.getNivel());
                    break;
            }
            out.println("        ");
            out.println("        ");
            printStatus(pikachu1);
            printStatus(pikachu2);
            out.println("---- --- --- --- --- ----");
            out.println("        ");
            out.println("        ");
            opcion = printMenu2();
            switch (opcion) {
                case 1:
                    out.println("Curando...");
                    pikachu2.curar();
                    break;
                case 2:
                    out.println(pikachu2.getNombre() + " ha subido de nivel!");
                    pikachu2.subirNivel();
                    break;
                case 3:
                    out.println(pikachu2.getNombre() + " ha usado un IMPACTRUENO!");
                    pikachu1.hit(pikachu2.getNivel());
                    break;
            }
            out.println("        ");
            out.println("        ");
            printStatus(pikachu1);
            printStatus(pikachu2);
            out.println("---- --- --- --- --- ----");
            out.println("        ");
            out.println("        ");
            turno++;
            int HP1 = pikachu1.getPuntosVida();
            int HP2 = pikachu2.getPuntosVida();

            if (HP1 <= 0 && HP2 <= 0) {
                printEmpate();
                System.exit(0);
            }
            if (HP1 <= 0) {
                printGanador(pikachu2);
                System.exit(0);
            }
            if (HP2 <= 0) {
                printGanador(pikachu1);
                System.exit(0);
            }
        } while (opcion != 0);
    }

    public static int printMenu1() throws IOException {
        out.println(ANSI_GREEN + "------ Jugador 1 ------");
        out.println("1. Curar");
        out.println("2. Subir nivel");
        out.println("3. Atacar");
        out.println("0. Rendirse");
        out.println("---- --- --- --- --- ----");
        int opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    public static int printMenu2() throws IOException {
        out.println(ANSI_BLUE + "------ Jugador 2 ------");
        out.println("1. Curar");
        out.println("2. Subir nivel");
        out.println("3. Atacar");
        out.println("0. Rendirse");
        out.println("---- --- --- --- --- ----");
        int opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    public static void printStatus(pikachu pikachu) throws IOException {
        out.print(ANSI_CYAN + pikachu.getNombre());
        out.print("  Nivel: ");
        out.print(pikachu.getNivel());
        out.print("  Puntos de vida: ");
        out.println(pikachu.getPuntosVida());
    }

    public static void printGanador(pikachu pikachu) throws IOException {
        out.println(ANSI_CYAN + "El ganador es ");
        out.print(pikachu.getNombre());
        out.println("Eres todo un maestro pokemon");
    }

    public static void printEmpate() throws IOException {
        out.println(ANSI_CYAN + "Hay un empate ");
        out.println("Eres un maestro pokemon!");
    }
}
