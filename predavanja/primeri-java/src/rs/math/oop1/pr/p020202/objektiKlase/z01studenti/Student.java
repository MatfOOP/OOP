package rs.math.oop1.pr.p020202.objektiKlase.z01studenti;

class Student {
    String ime;
    int brojIndeksa;
    int godinaUpisa;

    void stampajPodatke() {
        System.out.println("Ime studenta je: " + ime
                + ". Broj indeksa je " + brojIndeksa + "/" + godinaUpisa + ".");
    }
}