package primer03Stek;

//Enum koji nam sluzi za sve moguce operacije u nasem steku
//Struktura pravljenja enuma u Javi je sledeca:
public enum Operacija {
    PUSH_OPERACIJA(0),
	POP_OPERACIJA(1),
	TOP_OPERACIJA(2),
	SIZE_OPERACIJA(3),
	EXIT_OPERACIJA(4);

	private final int op;

	//privatan konstruktor kome se salje celi broj koji oznacava koja je to operacija
    private Operacija(int op) {
    	this.op = op;
	}
}
