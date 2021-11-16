package arrayList;

public class MyArrayList<E> {
    private int size = 0;
    private Object[] array;

   public void add(E newElement){   // добавление элемента
       if(size == array.length-1)
           resize(array.length*2);
       array[size++] = newElement;
   }

    private void resize(int newLength) {    //удвоение размера списка
       Object[] newArray = new Object[newLength];
       System.arraycopy(array, 0, newArray, 0, size);
       array = newArray;
    }

    public E get(int index) { //получение элемента по индексу
       return (E) array[index];
    }

    public void remove(int index) { //удаление элемента списка по его индексу
       for (int i = index; i< size; i++) {
           array[i] = array[i + 1];
           array[size] = null;
           size--;
       }
    }

    public int size(){  //определение количества элементов списка
       return size;
    }


}
