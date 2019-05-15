package rs.math.oop1.p120101.enumerisaniTipDodatnoInfo.z01.godisnjaDoba;

public enum GodisnjeDoba {
    PROLECE(92), LETO(91), JESEN(91), ZIMA(91);

    private int trajanjeDana;

    private GodisnjeDoba(int trajanjeDana){
        this.trajanjeDana = trajanjeDana;
    }

    public int getTrajanjeDana() {
        return trajanjeDana;
    }

    @Override
    public String toString(){
        return "[" + super.toString() + "|" + ordinal()+ "|" + trajanjeDana + "]";
    }

}
