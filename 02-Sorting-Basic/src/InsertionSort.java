public class InsertionSort {
    public InsertionSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 1;i<n;i++){
            //方法一
//            int minindex = i;
//            for(int j =i-1;j>=0;j--){
//                if(minindex<j)
//                    swap(arr,minindex,j);
//            }
            // 写法2
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    private static void swap(Object[] arr,int i,int j){
        Object t = arr[i];
        arr[i]=arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
