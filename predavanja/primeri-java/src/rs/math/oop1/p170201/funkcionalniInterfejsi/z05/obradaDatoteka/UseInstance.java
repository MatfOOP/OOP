package rs.math.oop1.p170201.funkcionalniInterfejsi.z05.obradaDatoteka;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable>
{
	void accept(T instance) throws X;
}
