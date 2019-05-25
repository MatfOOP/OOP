package rs.math.ispit201905.zadatak1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AlterirajuciIterabilni<T> implements Iterable<T> {

    private List<Iterable<T>> sadrzaj;

    public AlterirajuciIterabilni(Iterable<T> grupa1, Iterable<T> grupa2, Iterable<T> grupa3) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
        this.sadrzaj.add(grupa2);
        this.sadrzaj.add(grupa3);
    }

    public AlterirajuciIterabilni(Iterable<T> grupa1, Iterable<T> grupa2) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
        this.sadrzaj.add(grupa2);
    }

    public AlterirajuciIterabilni(Iterable<T> grupa1) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
    }

    @Override
    public Iterator<T> iterator() {
        return new AlternirajuciIterator();
    }

    private class AlternirajuciIterator implements Iterator<T> {
        private int aktuelniListIterator = -1;
        private List<Iterator<T>> listaIteratora;

        public AlternirajuciIterator() {
            listaIteratora = new ArrayList<>(sadrzaj.size());
            for (Iterable<T> iterable : sadrzaj) {
                listaIteratora.add(iterable.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            for (Iterator<T> it : listaIteratora) {
                if (it.hasNext()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T result;
                while (true) {
                    aktuelniListIterator = (aktuelniListIterator + 1) % listaIteratora.size();
                    if (listaIteratora.get(aktuelniListIterator).hasNext()) {
                        result = listaIteratora.get(aktuelniListIterator).next();
                        break;
                    }
                }
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}
