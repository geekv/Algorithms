public class SelectionSort {
    public SelectionSort(){}

    public static void sort(Comparable[] arr){
//          方法一
//        for(int i=0;i<arr.length;i++){
//            int minindex = i;
//            for(int j = i+1;j<arr.length;j++){
//                if(arr[j].compareTo(arr[minindex])<0)
//                    minindex=j;
//            }
//            swap(arr,i,minindex);
//        }
        //方法二  一样是O(n^2)的复杂度，数字越小，效率越高
        int left = 0,right =arr.length-1;
        while (left<right){
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0)
                swap(arr, minIndex, maxIndex);

            for (int i=left+1;i<right;i++){
                if(arr[i].compareTo(arr[minIndex])<0)
                    minIndex =i;
                else if(arr[i].compareTo(arr[maxIndex])>0)
                    maxIndex =i;
            }
            swap(arr,left,maxIndex);
            swap(arr,right,maxIndex);
            left ++;
            right --;
        }
    }
    private static void swap(Object[] arr,int i,int j){
        Object t = arr[i];
        arr[i]=arr[j];
        arr[j] = t;
    }
    public static void main(String[] args){
//        Integer [] arr ={10,9,8,7,6,5,4,3,2,1};
//        SelectionSort.sort(arr);
//        for (int i = 0;i<arr.length;i++){
//            System.out.println(arr[i]);
//            System.out.println(' ');
//        }
//
//    // 测试Double
//        Double[] b = {4.4, 3.3, 2.2, 1.1};
//        SelectionSort.sort(b);
//        for( int i = 0 ; i < b.length ; i ++ ){
//        System.out.print(b[i]);
//        System.out.print(' ');
//    }
//        System.out.println();
//
//    // 测试String
//    String[] c = {"D", "C", "B", "A"};
//        SelectionSort.sort(c);
//        for( int i = 0 ; i < c.length ; i ++ ){
//        System.out.print(c[i]);
//        System.out.print(' ');
//    }
//        System.out.println();
//
//    // 测试自定义的类 Student
//    Student[] d = new Student[4];
//    d[0] = new Student("D",90);
//    d[1] = new Student("C",100);
//    d[2] = new Student("B",95);
//    d[3] = new Student("A",95);
//        SelectionSort.sort(d);
//        for( int i = 0 ; i < d.length ; i ++ )
//            System.out.println(d[i]);

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort", arr);

        return;
}
}
