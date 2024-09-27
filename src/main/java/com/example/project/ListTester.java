package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List <T> list, int n)
    {
        if (list.empty())
            return;

        list.findFirst();
        if (list.last())
            return;

        T[] shiftArr = (T[]) new Object[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            T shifted = list.retrieve();
            shiftArr[count++] = shifted;
            if (!list.last())
                list.findNext();
            else
                list.findFirst();
        }

        while (!list.last())
            list.findNext();

        for (int i = 0; i < n; i++) {
            list.insert(shiftArr[i]);
        }

        list.findFirst();
        for (int i = 0; i < n; i++) {
            list.remove();
        }
    }
    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2)
    {
        if (l1.empty())
            return;

        l1.findFirst();
        l2.insert(l1.retrieve());

        while (true) {
            if (l1.last()) {
                break;
            } else {
                l1.findNext();
            }
            T tmp = l2.retrieve();
            l2.update(l1.retrieve());
            l2.insert(tmp);
            l2.findFirst();
        }
    }
}
