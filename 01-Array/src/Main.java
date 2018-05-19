public class Main {

    public static void main(String[] args) {

//        Array arr = new Array(20);
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,10);
        System.out.println(arr);
//        System.out.println(arr.get(3));
//        arr.set(1,10);
//        System.out.println(arr);
//        arr.remove(2);
//        arr.removeFrist();
//        System.out.println(arr);
    }
}
