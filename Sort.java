package sort;

public class Sort {
    int[] A = {5,1,4,5,6,2,4,8,6,5,1,5,6,9,8,7,6,5,4, 3, 2, 1};

    public Sort() {
        Sort(A, 0, A.length - 1);
        printA(A);
    }

    public static void main(String[] args) {
        new Sort();
    }

    void Sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            Sort(A, p, q);
            Sort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }

    void Merge(int[] A, int p, int q, int r) {
        if (p == q) {
            if (A[p] > A[r]) {
                int a = A[p];
                A[p] = A[r];
                A[r] = a;
            }
        } else {
            q++;
            int a = p;
            int b = q;
            int[] B = new int[r - p + 1];

            for (int i = 0; i < r - p + 1; i++) {
                if (a < q && b <= r) {
                    if (A[a] < A[b]) {
                        B[i] = A[a];
                        a++;
                    } else {
                        B[i] = A[b];
                        b++;
                    }
                } else if (a < q) {
                    B[i] = A[a];
                    a++;
                } else if (b <= r) {
                    B[i] = A[b];
                    b++;
                }
            }

            System.arraycopy(B, 0, A, p, B.length);
        }
    }

    void printA(int[] A) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i : A) {
            sb.append(i + ",");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
