package start.summary20240315;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Box implements Iterable<String> {
    String itemA;
    String itemB;
    String itemC;

    public Box(String itemA, String itemB, String itemC) {
        this.itemA = itemA;
        this.itemB = itemB;
        this.itemC = itemC;
    }

    @Override
    public Iterator<String> iterator() {
        return new BoxIterator();
    }

    private class BoxIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < 3;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the Box");
            }
            currentIndex++;
            return getItemByIndex(currentIndex);
        }

        private String getItemByIndex(int index) {
            if (index == 1) {
                return itemA;
            } else if (index == 2) {
                return itemB;
            } else if (index == 3) {
                return itemC;
            } else {
                throw new NoSuchElementException("No more elements in the Box");
            }
        }
    }

    public static void main(String[] args) {
        Box box = new Box("Item A", "Item B", "Item C");
        for (String item : box) {
            System.out.println(item);
        }

        }
    }
