package rs.math.oop1.z080201.interfejsi.z02.ljudi;

/**
 * Klasa <code> Student </code> opisuje Studenta
 *
 * @author vlado
 */
class Student extends Covek implements Deskripcija, Kvalitet {
   String smer;
   String brojIndeksa;
   int godinaStudija;
   int dobrota = 95;
   int postenje = 90;

   public Student(String smer, String brojIndeksa, int godinaStudija, int dobrota, int postenje) {
      this.smer = smer;
      this.brojIndeksa = brojIndeksa;
      this.godinaStudija = godinaStudija;
      this.dobrota = dobrota;
      this.postenje = postenje;
   }

   public void predstaviSe() {
      System.out.println("Student: " + ime + " " + prezime + " " + smer + " "
            + brojIndeksa + " " + godinaStudija + ".");
   }

   public int jeDobar() {
      return dobrota;
   }

   public int jePosten() {
      return postenje;
   }

}