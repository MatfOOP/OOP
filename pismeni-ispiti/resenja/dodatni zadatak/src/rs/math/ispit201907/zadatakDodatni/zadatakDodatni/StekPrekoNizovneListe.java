package rs.math.ispit201907.zadatakDodatni.zadatakDodatni;

import java.util.*;

public class StekPrekoNizovneListe<E> extends AbstractCollection<E> {
    private ArrayList<E> sadrzina = new ArrayList<E>();
    private long indikatorPromeneStrukture = 0;

    private class StekPrekoNizovneListeIterator implements Iterator<E> {
        int indeks = 0;
        long indikatorPromeneStrukture;

        StekPrekoNizovneListeIterator(long indikatorPromeneStrukturePriKreiranju) {
            indikatorPromeneStrukture = indikatorPromeneStrukturePriKreiranju;
        }

        @Override
        public boolean hasNext() {
            if (indikatorPromeneStrukture != StekPrekoNizovneListeIterator.this.indikatorPromeneStrukture)
                throw new ConcurrentModificationException();
            return indeks < sadrzina.size();
        }

        @Override
        public E next() {
            if (indikatorPromeneStrukture != StekPrekoNizovneListeIterator.this.indikatorPromeneStrukture)
                throw new ConcurrentModificationException();
            return sadrzina.get(indeks++);
        }
 }

    public SkupPrekoNizovneListe(Collection<E> kolekcija) {
        for (E elem : kolekcija)
            this.add(elem);
    }

    public SkupPrekoNizovneListe(Collection<E>... kolekcije) {
        for (Collection<E> kolekcija : kolekcije)
            for (E elem : kolekcija)
                this.add(elem);
    }

    @Override
    public boolean add(E elemenat) {
        if (sadrzina.contains(elemenat))
            return false;
        sadrzina.add(elemenat);
        indikatorPromeneStrukture++;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new SkupPrekoNizovneListeiterator(indikatorPromeneStrukture);
    }

    @Override
    public int size() {
        return sadrzina.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (E x : sadrzina)
            sb.append(x + ", ");
        String ret = sb.toString();
        return ret.substring(0, ret.length() - 2) + "}";
    }
}
