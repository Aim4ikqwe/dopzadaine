import java.util.*;
interface Expression{
    boolean isEqual ( int a ,int  b);
}
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите метод сортировки up (по возрастанию )или down (по убыванию)");
        String in = input.nextLine();
        HeapSort ob = new HeapSort();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        if (in.equals("up")) {
            Expression x = (a, b) -> a > b;
            ob.sort(array, x);
        } else {
            Expression x = (a, b) -> a < b;
            ob.sort(array, x);
        }
        System.out.println("\n Отсортированный массив");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
    class HeapSort
    {
        public void sort(int arr[], Expression x)
        {
            int n = arr.length;

            // Построение кучи (перегруппируем массив)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i, x);

            // Один за другим извлекаем элементы из кучи
            for (int i=n-1; i>=0; i--)
            {
                // Перемещаем текущий корень в конец
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Вызываем процедуру heapify на уменьшенной куче
                heapify(arr, i, 0, x);
            }
        }

        // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
        void heapify(int arr[], int n, int i, Expression x)
        {
            int largest = i; // Инициализируем наибольший элемент как корень
            int l = 2*i + 1; // левый = 2*i + 1
            int r = 2*i + 2; // правый = 2*i + 2

            // Если левый дочерний элемент больше корня
            if (l < n && x.isEqual(arr[l] , arr[largest]))
                largest = l;

            // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
            if (r < n && x.isEqual (arr[r], arr[largest]))
                largest = r;
            // Если самый большой элемент не корень
            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
                heapify(arr, n, largest, x);
            }
        }

        /* Вспомогательная функция для вывода на экран массива размера n */
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }

    }
