class PokretanjeOmotacPrimitivnogTipa {

    public static void main(String[] args) {
        //tzv. "omotač" referentni tipovi za primitive tipove
        Integer ceoBroj1 = new Integer(3);
        Integer ceoBroj2 = 3; //skraćeni zapis, autoboxing
        System.out.println(ceoBroj1);
        System.out.println(ceoBroj1.intValue());
    }
}


