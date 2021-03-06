import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

// Kristen Brandt 171482
// Fecha de entrega 3 de Marzo 2019
// Hoja de trabajo no 6
public class Main {
    static String encendermenu = "\n Cartas : \n" +
            "\t Ingresar la direccion del archivo con las cartas que quiere:\n" +
            "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
            "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";


    static String menuCartas = "\n INGRESE COMO LE GUSTARIA GUARDAR LAS CARTAS \n" +
            "\t1. HashMap \n" +
            "\t2. TreeMap \n" +
            "\t3. LinkedHashMap ";

    static String menuOpciones = "\n OPCIONES \n" +
            "\t1. Agregar una carta a coleccion \n" +
            "\t2. Mostrar el tipo de carta al buscar por nombre \n" +
            "\t3. Mostrar cartas de la coleccion del usuario \n " +
            "\t4. Mostrar cartas de la coleccion ordenadas por tipo\n"+
            "\t5. Mostrar cartas existentes\n"+
            "\t6. Mostrar cartas existentes ordenadas por tipo\n"+
            "\t7. Salir del programa.\n";


    public static void main(String[] args) {
        boolean deleViaje = true;
        Scanner input = new Scanner(System.in);
        FactoryCartas factory = new FactoryCartas();


        do {
            System.out.print(menuCartas);
            System.out.println("\n");
            int que = input.nextInt();
            boolean seguir = false;
            String listo = Integer.toString(que);
            switch (listo) {
                case "1":
                    System.out.println("Se guardaran las cartas como HashMap");
                    seguir = true;
                    break;
                case "2":
                    System.out.println("Se guardaran las cartas como TreeMap");
                    seguir = true;
                    break;
                case "3":
                    System.out.print("Se guardaran las cartas como LinkedHashMap");
                    seguir = true;
                    break;
                default:
                    System.out.print("La opcion no fue encontrada asi que se va a hacer con HashMap");
                    seguir = true;
                    break;
            }


            do{
                System.out.println(encendermenu);
                String intento = input.nextLine();
                String archivo = input.nextLine();
                boolean opcionesmen = false;
                if (!archivo.equals("2")) {
                    File archivoUsuario = new File(archivo);
                    //El codigo de buffered reader es tomado de la siguiente pagina.
                    //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                    Map<String,Cartas> CartaUsada = factory.getImplementacion(listo);
                    Map<String,Cartas> CollecionPersonal = factory.getImplementacion(listo);
                    try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuario))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(Pattern.quote("|"));
                            String part1 = parts[0];
                            String part2 = parts[1];
                            //Agrega cada de las partes nombre y tipo a una carta
                            Cartas carta = new Cartas(part1,part2);
                            CartaUsada.put(carta.getNombre(),carta);
                        }
                        opcionesmen = true;

                        do{
                            System.out.print(menuOpciones);
                            int opciones = input.nextInt();
                            switch (opciones){
                                case 1:
                                    //Agregar una carta a coleccion
                                    System.out.println("Ingrese el nombre de la carta que quiere agregar a su coleccion: \n");
                                    System.out.println("Si el nombre no es aceptado al primer intento ponga el nombre de nuevo, es por un problema de cache \n");
                                    String nada = input.nextLine();
                                    String cartadeseada = input.nextLine();

                                    if (CartaUsada.containsKey(cartadeseada)) {
                                        Cartas card =(Cartas)CartaUsada.get(cartadeseada);
                                        System.out.println("Cuantas cartas quiere agregar? (Ingrese un numero):\n");
                                        System.out.println("Si el numero no es aceptado al primer intento ponga el numero de nuevo, es por un problema de cache \n");
                                        String numero = input.nextLine();
                                        Integer.parseInt(numero);
                                        card.setCantidad(Integer.parseInt(numero));
                                        CollecionPersonal.put(cartadeseada,CartaUsada.get(cartadeseada));
                                        System.out.print("Se agrego: \n" + CartaUsada.get(cartadeseada) +"a su coleccion correctamente.\n");
                                    } else
                                        System.out.println("No se encontro una carta con ese nombre, no se pudo agregar a su coleccion \n");
                                    break;
                                case 2:
                                    //Mostrar el tipo de carta al buscar por nombre
                                    System.out.println("Ingrese el nombre de la carta que quiere buscar: \n");
                                    System.out.println("Si el nombre no es aceptado al primer intento ponga el nombre de nuevo, es por un problema de cache \n");
                                    String nosirvew = input.nextLine();
                                    String cartanombre = input.nextLine();
                                    if (CartaUsada.containsKey(cartanombre)) {
                                        System.out.print(CartaUsada.get(cartanombre));
                                    } else
                                        System.out.println("No se encontro una carta con ese nombre, no se pudo agregar a su coleccion \n");
                                    break;

                                case 3:
                                    System.out.println("Se van a imprimir todas las cartas de la coleccion del usuario: \n");
                                    System.out.print(CollecionPersonal.values());
                                    //Mostrar cartas de la coleccion del usuario
                                    break;

                                case 4:
                                    // Mostrar cartas de la coleccion ordenadas por tipo
                                    ArrayList<Cartas> Monstruo = new ArrayList<>();
                                    ArrayList<Cartas> Trampa = new ArrayList<>();
                                    ArrayList<Cartas> Hechizo = new ArrayList<>();
                                    for (Map.Entry<String,Cartas> wazawaza : CollecionPersonal.entrySet()) {

                                        if (wazawaza.getValue().getTipo().equals("Monstruo")){
                                            Monstruo.add(wazawaza.getValue());
                                        }else if (wazawaza.getValue().getTipo().equals("Trampa")){
                                            Trampa.add(wazawaza.getValue());

                                        }else if (wazawaza.getValue().getTipo().equals("Hechizo")){
                                            Hechizo.add(wazawaza.getValue());
                                        }
                                    }
                                    for (Cartas card: Monstruo){
                                        System.out.println(Monstruo);
                                    }
                                    for (Cartas card: Trampa){
                                        System.out.println(Trampa);
                                    }
                                    for (Cartas card: Hechizo){
                                        System.out.println(Hechizo);
                                    }
                                    // TODO: 2019-03-03
                                    break;

                                case 5:
                                    //Mostrar cartas existentes
                                    System.out.println("Se van a imprimir todas las cartas existentes: \n");
                                    System.out.print(CartaUsada.values());
                                    break;

                                case 6:
                                    //Mostrar cartas existentes ordenadas por tipo

                                    ArrayList<Cartas> Monster = new ArrayList<>();
                                    ArrayList<Cartas> Trampas = new ArrayList<>();
                                    ArrayList<Cartas> Hechizos = new ArrayList<>();
                                    for (Map.Entry<String,Cartas> wazawaza : CartaUsada.entrySet()) {

                                     if (wazawaza.getValue().getTipo().equals("Monstruo")){
                                         Monster.add(wazawaza.getValue());
                                     }else if (wazawaza.getValue().getTipo().equals("Trampa")){
                                         Trampas.add(wazawaza.getValue());

                                    }else if (wazawaza.getValue().getTipo().equals("Hechizo")){
                                         Hechizos.add(wazawaza.getValue());
                                     }
                                    }
                                    for (Cartas card: Monster){
                                        System.out.println(Monster);
                                    }
                                    for (Cartas card: Trampas){
                                        System.out.println(Trampas);
                                    }
                                    for (Cartas card: Hechizos){
                                        System.out.println(Hechizos);
                                    }
                                    break;

                                case 7:
                                    //salir del programa
                                    System.out.println("Saliendo del programa");
                                    opcionesmen = false;
                                    seguir = false;
                                    deleViaje = false;
                                    break;
                            }
                        }while (opcionesmen);

                        seguir =false;

                    } catch (Exception e) {
                        System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                    }
                }


            }while (seguir);

            deleViaje = false;

        }while (deleViaje);

    }
}
