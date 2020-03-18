class PokretanjeNiskeKreiranje {

    public static void main(String[] args) {
        //referentni tip String
        String string1 = new String("Ovo je neki tekst.");
        //skraćena zapis, sa implicitnim pozivom ključne reči new
        String string2 = "Ovo je neki tekst.";
        System.out.println(string2);
        System.out.println(string2.substring(1, 4));
        System.out.println(string1.concat(string2));
        System.out.println(string1 + string2);
    }
}


