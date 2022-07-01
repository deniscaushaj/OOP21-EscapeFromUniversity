package escapefromuniversity.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * iterator for ID.
 *
 */
public class IteratorOfID implements Iterator<Integer> {

    private int actualID;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.actualID++;
    }

}
