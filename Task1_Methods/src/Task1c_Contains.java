
public class Task1c_Contains {
    static int indexOf(int[] a, int k){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==k){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr={5, 3, 7, 6};
        System.out.println(indexOf(arr, 7));
    }
}

