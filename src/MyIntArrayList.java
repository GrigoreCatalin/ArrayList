import java.util.Arrays;

public class MyIntArrayList {
    private int[] elements;
    private int size;

    public MyIntArrayList() {
        this(10);
    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
    }

    public MyIntArrayList(MyIntArrayList initialArray) {
        if (initialArray.size != 0) {
            this.elements = initialArray.elements;
            this.size = initialArray.size;
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indexul se afla in afara intervalului.");
            return true;
        } else
            return false;
    }

    public void add(int index, int element) {
        if (checkIndex(index) == true) {
            this.size = 0;
        } else {
            if (this.size == this.elements.length) {
                this.elements = Arrays.copyOf(this.elements, this.size * 2);
            }
            for (int i = this.size; i > index; i--) {
                this.elements[i] = this.elements[i - 1];
            }

            this.elements[index] = element;
            this.size++;
        }
    }

    public boolean add(int e) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[this.size] = e;
        this.size++;

        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        if (checkIndex(index) == false) {
            return this.elements[index];
        } else {
            this.size = 0;
            return -1;
        }
    }

    public int indexOf(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        int lastIndex = 0;
        boolean check = false;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                check = true;
                lastIndex = i;
            }
        }
        if (check) {
            return lastIndex;
        } else {
            return -1;
        }
    }

    public boolean remove(int e) {
        boolean check = false;
        int firstOccurrence = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                check = true;
                firstOccurrence = i;
                break;
            }
        }
        if (check == true) {
            this.size--;
            for (int i = firstOccurrence; i < this.size; i++) {
                this.elements[i] = this.elements[i + 1];
            }
        }
        return check;
    }

    public int removeElementAtIndex(int index) {
        int removeIndex = this.elements[index];

        if (checkIndex(index) == true) {
            return -1;
        }

        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;

        return removeIndex;
    }

    public void clear() {
        this.size = 0;
    }

    public int set(int index, int e) {
        if (checkIndex(index) == true) {
            this.size = 0;
            return -1;
        }

        int previouslyElement = this.elements[index];
        this.elements[index] = e;
        return previouslyElement;
    }

    private boolean checkSize(int initialSize) {
        if (initialSize == 0) {
            System.out.println("NullPointerException");
            return true;
        } else {
            return false;
        }
    }

    public boolean addAll(MyIntArrayList initialArray) {
        if (checkSize(initialArray.size) == true) {
            this.size = 0;
            return false;
        }
        for (int i = 0; i < initialArray.size(); i++) {
            add(initialArray.get(i));
        }
        return true;
    }

    public boolean addAll(int index, MyIntArrayList initialArray) {
        if (checkIndex(index) == true) {
            this.size = 0;
            return false;
        } else if (checkSize(initialArray.size) == true) {
            this.size = 0;
            return false;
        }

        for (int i = 0; i < initialArray.size; i++) {
            add(index, initialArray.get(initialArray.size - i - 1));
        }
        return true;
    }

    public int[] toArray() {
        int[] newArray = Arrays.copyOf(this.elements, this.elements.length);
        return newArray;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, minCapacity);
        }
    }

    public void trimToSize() {
        if (this.elements.length > this.size()) {
            this.elements = Arrays.copyOf(this.elements, this.size());
        }
    }
}
