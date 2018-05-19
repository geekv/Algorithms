public class InserttionSort1 {
    private InserttionSort1(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++) {
            // 写法1
//            for (int j = i; j > 0; j--)
//                if (arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;
            //写法二
            Comparable e = arr[i];
            int j;
            for(j =i;j>0&&arr[j-1].compareTo(e)>0;j--)
                arr[j] =arr[j-1];           //swap要三次操作，这个只用一次操作。
            arr[j]=e;
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InserttionSort1", arr);

        return;
    }
}
