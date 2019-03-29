//Пример илуструје употребу switch наредбе када је условна променљива типа String.

/*
Задатак је на основу задатог записа Јава оператора одредити којој групи оператора он припада.
*/

package rs.math.oop1.p040607.naredbeGrananja.z04.switchIzraz;

public class TipOperatora {

    public static void main(String[] args) {
        String operator = ">>";
        switch (operator) {
            case "+":
            case "-":
                System.out.println("Aditivni operator");
                break;
            case "*":
            case "/":
                System.out.println("Multiplikativni operator");
                break;
            case "<":
            case ">":
            case "==":
                System.out.println("Relacioni operator");
                break;
            case ">>":
            case "<<":
            case ">>>":
            case "|":
            case "&":
            case "~":
            case "^":
                System.out.println("Bitovski operator");
                break;
            default:
                System.out.println("Nepoznati operator");

        }
    }
}
