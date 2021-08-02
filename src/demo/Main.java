package demo;

import java.util.Scanner;


/**
 * @author vastian
 */
public class Main {

    public static void main(String[] args) {

        while (true) {
            col = SC.nextInt();
            row = SC.nextInt();

            // 吃掉int后面的换行
            SC.nextLine();
            if (col == 0 && row == 0) {
                break;
            }

            count = 0;
            // 读入地图
            inputMap();

            // 找到起点@
            findStart();

            // 从起点开始找黑砖
            dfs(sx, sy);

            System.out.println(count);
        }

    }

    /**
     * DX、DY为四个方向的移动向量 上：(0,-1) 下：(0,1) 左：(-1,0) 右：(1,0)
     */
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};
    private static final Scanner SC = new Scanner(System.in);


    /**
     * count 记录黑砖个数
     * sx, sy 对应起点@的坐标 (sx,sy)
     * row, rol 对应地图大小 行数，列数
     * map 存地图信息
     */
    private static int count = 0;
    private static int sx, sy, row, col;
    private static char[][] map;

    public static void inputMap() {
        // 读取地图
        map = new char[row][];
        for (int i = 0; i < row; i++) {
            map[i] = SC.nextLine().toCharArray();
        }
    }

    public static void findStart() {
        // 遍历地图，找到唯一的起点@的坐标 (sx,sy)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '@') {
                    sx = i;
                    sy = j;
                    return;
                }
            }
        }
    }

    public static void dfs(int r, int c) {

        // 将走过的黑砖标记为红砖
        map[r][c] = '#';
        count++;
        // 遍历DX、DY得到四个方向
        for (int i = 0; i < 4; i++) {
            // tr、tc为下一步可能走的地方
            int tr = r + DX[i];
            int tc = c + DY[i];
            // 在地图范围内且是黑砖才能继续走
            if (0 <= tr && tr < row && 0 <= tc && tc < col && map[tr][tc] == '.') {
                dfs(tr, tc);
            }
        }
    }



}