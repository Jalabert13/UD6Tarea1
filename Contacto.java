import java.util.ArrayList;
import java.util.Scanner;

public class Contacto {
    String name;
    String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;

    }


    public static String createContact(String getName, String getPhoneNumber) {
        return "Nombre: " + getName + "Numero de telefono: " + getPhoneNumber;
    }

    public static class TelefonoMovil {
        String myNumber;
        private static ArrayList<Contacto> myContacts =  new ArrayList<Contacto>();

        public TelefonoMovil(String myNumber, ArrayList<Contacto> myContacts) {
            this.myNumber = myNumber;
            this.myContacts = myContacts;

        }

        public static int findContact(Contacto cont) {
            int index = myContacts.indexOf(cont);
            if (index >= 0) {
                return index;
            } else {
                return -1;
            }
        }

        private static int findContact(String conts) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equals(conts)) {
                    return i;
                }
            }
            return 0;
        }

        public static boolean addNewContact(Contacto cont) {
            if (findContact(cont) == -1) {
                myContacts.add(cont);
                return true;
            } else {

                return false;
            }
        }

        public static boolean updateContact(Contacto conta, Contacto contn) {
            if (findContact(conta) == -1) {
                return false;
            } else {
                int index = myContacts.indexOf(conta);
                myContacts.set(index, contn);
                return true;
            }
        }

        public static boolean removeContact(Contacto cont) {
            if (findContact(cont) == -1) {
                return false;
            } else {
                int index = myContacts.indexOf(cont);
                myContacts.remove(cont);
                return true;
            }
        }

        public static Contacto queryContact(String contquery) {
            if (findContact(contquery) == 1) {
                return null;
            } else {
                return myContacts.get(findContact(contquery));
            }
        }

        public static void printContacts() {

            System.out.println("Tenemos " + myContacts.size() + " contactos.");
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println(myContacts.get(i).getName()+" ----> "+myContacts.get(i).getPhoneNumber());
            }

        }
    }

    public static class main {
        public static void crearnuevocont(){
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Nombre del contacto");
            String name = sc2.next();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("Numero de teléfono");
            String numero = sc3.next();
            System.out.println("Hola " + name + " con numero de telefono " + numero + " tu contacto ha sido creado");
            System.out.println("--------------------------------------------------------");
            Contacto cont = new Contacto(name, numero);
            TelefonoMovil.addNewContact(cont);
        }

        public static void actualizarcont(){
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué contacto quieres actualizar?: ");
            String nombre =  sc.next();
            TelefonoMovil.queryContact(nombre);
            if (TelefonoMovil.queryContact(nombre) != null) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("¿Cúal es el nuevo nombre del contacto?: ");
                String nombre2 = sc3.next();
                Scanner sc4 = new Scanner(System.in);
                System.out.println("¿Cúal es el nuevo numero del contacto?: ");
                String numero2 = sc4.next();
                TelefonoMovil.updateContact(TelefonoMovil.queryContact(nombre), new Contacto(nombre2, numero2));
            }
            else {
                System.out.println("Ese contacto no existe");
            }
        }

        public  static void quitarcont(){
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué contacto quieres eliminar?: ");
            String nombre =  sc.next();
            TelefonoMovil.queryContact(nombre);
            if (TelefonoMovil.queryContact(nombre) != null) {
                System.out.println("El usuario ha sido eliminado");
                TelefonoMovil.removeContact(TelefonoMovil.queryContact(nombre));
            }
            else {
                System.out.println("El usuario no existe en la lista");}
        }

        public static void buscarcont(){
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué contacto quieres buscar?: ");
            String nombre =  sc.next();
            TelefonoMovil.queryContact(nombre);
            if (TelefonoMovil.queryContact(nombre) != null) {
                TelefonoMovil.findContact(nombre);
                System.out.println("La informacion de " + nombre + " es: ");

             //   System.out.println(TelefonoMovil.myContacts.get(TelefonoMovil.findContact()).getName()+" ----> "+ TelefonoMovil.myContacts.get().getPhoneNumber());
                nombre = null;
            }
            else {
                System.out.println("El usuario no existe en la lista");}
        }

        public static void imprimirMenu(){
            System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES: ");
            System.out.println("--------------------------------------------------------");
            System.out.println("0-Salir");
            System.out.println("1-imprimir contactos");
            System.out.println("2-agregar un nuevo contacto");
            System.out.println("3-actualizar un contacto existente");
            System.out.println("4-eliminar contacto de la lista");
            System.out.println("5-buscar/encontrar contacto por nombre");
            System.out.println("6-volver a imprimir la lista de opciones");
            System.out.println("--------------------------------------------------------");
        }

        public static void main(String[] args) {
            Scanner sc1 = new Scanner(System.in);
            boolean continuar = true;
            while (continuar) {
                imprimirMenu();
                int resp = sc1.nextInt();
                switch (resp) {
                    case 0:
                        System.out.println("Gracias por su aclaración");
                        continuar = false;
                        break;
                    case 1:
                        TelefonoMovil.printContacts();
                        break;
                    case 2:
                        crearnuevocont();
                        break;

                    case 3:
                        actualizarcont();
                        break;

                    case 4:
                    quitarcont();
                    break;

                    case 5:
                    buscarcont();
                    break;

                    case 6:
                    imprimirMenu();
                    break;

                    default:
                        System.out.println("Ese número no es una opción del menú");
                }


            }


        }
    }
}

