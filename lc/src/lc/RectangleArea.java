package lc;

/**
 * Created by zzren on 7/6/2016.
 */
public class RectangleArea {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        int overlap = ((Math.min(C,G)<Math.max(A,E))?0:(Math.min(C,G) - Math.max(A,E))) * ((Math.min(D,H)<Math.max(B,F))?0:(Math.min(D,H) - Math.max(B,F)));
        return (area1 - overlap + area2);
    }
}
