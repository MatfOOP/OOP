public class P050104SistemskeOsobineZ01CitanjePokretanje {
    public static void main(String[] args) {

        // prikazuje sistemsku osobinu korisnicki direktorijum
        System.out.println("korisnicki direktorijum: " + System.getProperty("user.dir"));

        // prikazuje sistemsku osobinu naziv operativnog sistema
        System.out.println("operativni sistem: " + System.getProperty("os.name"));

        // prikazuje sistemsku osobinu verzija Java izvrsnog okruzenja
        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));

        // prikazuje sistemsku osobinu putanja do klasama
        System.out.println("putanja do klasa: " + System.getProperty("java.class.path"));

        // prikazuje sistemsku osobinu zavrsetak linije
        System.out.println("zavrsetak linije: " + System.getProperty("line.separator"));
    }
}
