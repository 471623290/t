public class tool {
    public static double GetDegree(int x , int y ,int x_end,int y_end){
        int a = Math.abs(x-x_end);
        int b = Math.abs(y-y_end);
        double z=Math.sqrt(a*a+b*b);
        double degree = (float)(Math.asin(b/z));
        int tx = x_end-x;
        int ty = y_end-y;
        if(tx > 0 && ty<0)
            degree = 6.28 - degree;
        if(tx < 0 && ty>0)
            degree = 3.14 - degree;
        if(tx < 0 && ty < 0)
            degree+=3.14;
        return degree;
    }

    public static void main(String[] args) {
        System.out.println(  tool.GetDegree(0,0,1,1 ));
    }
}
