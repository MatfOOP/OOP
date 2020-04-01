package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

class Student extends Covek
{
  private String smer;
  private String brojIndeksa;
  private int godinaStudija;

  public Student(String ime, String prezime, String smer, String brojIndeksa, int godinaStudija) {
    super(ime, prezime);
    this.smer = smer;
    this.brojIndeksa = brojIndeksa;
    this.godinaStudija = godinaStudija;
  }

  public String getSmer() {
    return smer;
  }

  public void setSmer(String smer) {
    this.smer = smer;
  }

  public String getBrojIndeksa() {
    return brojIndeksa;
  }

  public void setBrojIndeksa(String brojIndeksa) {
    this.brojIndeksa = brojIndeksa;
  }

  public int getGodinaStudija() {
    return godinaStudija;
  }

  public void setGodinaStudija(int godinaStudija) {
    this.godinaStudija = godinaStudija;
  }

  @Override
  public void predstaviSe()
  {
    System.out.println("Student: " 
      + getIme() + " " + getPrezime() + " "
      + smer +" " + brojIndeksa + " "
      + godinaStudija + ".");
  }
}