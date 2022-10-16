
public class program_tree {

    public static int sum(int a, int d) {
        a = a + d;
        return a;
    }
    
    public static int mult(int a, int c) {
        a = a * c;
        return a;
    }

    
    public static void main(String[] args) {
        int base = 2;
        int b = 8;
        int c = 2;
        int end = 1;
        int[] tree_list = new int[(int) Math.pow(2, b/end)];

        tree_list[0] = base;
        all_var(tree_list, base, b, c, end);
        tree_print(tree_list);   
    }

    public static void all_var(int lst[], int a, int b, int c, int d) {
        for (int i = 0; i < lst.length/2-1; i++) {
            int m = 0;
            int s = 0;
            if (lst[i] != 0) {
                m = mult(lst[i], c);
                s = sum(lst[i], d);
                
                if (m <= b) {
                    lst[2*i+1] = m; 
                }
                else lst[2*i+1] = 0;
                if (s <= b) {
                    lst[2*i+2] = s;
                }  
                else lst[2*i+2] = 0;
                if (m == b) path_out(i, 1);
                if (s == b) path_out(i, 2);
            }
        }
    }
    public static void path_out(int i, int t) {
        int path = (2*i+t);
        String res = "";
        while (path > 0) {
            if (path %2 == 0) {
                res =  "Sum+D " + res;
            }
            else {
                res =  "Mul*C " + res;
            }
            path = (path-1)/2;
        }
        System.out.println(res);
    }



    public static void tree_print(int []lst) {
        int last = 0;
        for (int i = 0; i < lst.length; i = (i+1)*2 ) {
            for (int j = last; j <= i; j++) {
                // System.out.print(last + ":" + lst[j] + " "); //with key
                System.out.print(lst[j]); //brief
                last++;
            }
            System.out.println();
        }
    }
}