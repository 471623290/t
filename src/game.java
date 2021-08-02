

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class game {
    static  boolean live = true;
    public static void main(String[] args) {
        Windows game =  new Windows(856,500, "Windows_开发桌游_Game1.0");

    }
}
class Windows  extends JFrame {
    int w,h,x_mouse,y_mouse;
    ball  whiteball = new ball(130,265,0,true);
    String title;
    //ClassLoader.getSystemResource("images/white_ba.png")
    Image desk = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/desk.jpg"));
    Image ball_white = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/white_ball.png"));
    public Windows(int w, int h, String title) {
        this.w = w;
        this.h = h;
        this.title = title;
        setVisible(true);
        setSize(w,h);
        setDefaultCloseOperation(3);
        setTitle(title);
        setResizable(false);
        int windowWidth = this.getWidth(); // 获得窗口宽
        int windowHeight = this.getHeight(); // 获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width; // 获取屏幕的宽
        int screenHeight = screenSize.height; // 获取屏幕的高
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
        ImageIcon imageIcon = new ImageIcon(getClass().getResource( "images/ico.png"));
        this.setIconImage(imageIcon.getImage());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1)
                {
                    System.out.println("left button is Clicked");
                    if(whiteball.getSpeed() == 0){
                        System.out.println("可以画球杆");
                        y_mouse = e.getY();
                        x_mouse = e.getX();
                        whiteball.setDegree ((int)tool.GetDegree( x_mouse,y_mouse,whiteball.getX()+20,whiteball.getY()+20));
                    }
                }else if(e.getButton() ==  3){
                    if(whiteball.getSpeed() == 0){
                            whiteball.setSpeed(30);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        while(true){
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void DrawCue(int x, int y  ) {
        Graphics g = new DebugGraphics();

    }

    Image off = null;
    @Override
    public void paint(Graphics g) {

        if( off == null){
                off  = this.createImage(856,500);
        }
        Graphics gimage = off.getGraphics();
        gimage.setColor(Color.black);
        gimage.fillRect(0,0,856,500);
        gimage.drawImage(desk,0,0,null);
        if(whiteball.getX() < 30 && whiteball.getX()  > 856 - 30 - 40  ) {
            whiteball.setDegree(3.14-whiteball.getDegree());
        }
        if(whiteball.getY() < 30 && whiteball.getX()  > 500 - 30 - 40  ) {whiteball.setDegree(-1*whiteball.getDegree());
        }
        gimage.drawString("球杆",x_mouse,y_mouse);
        if(whiteball.getSpeed() > 0)
        {

            whiteball.setX((int) (whiteball.getX()+10*Math.cos(whiteball.getDegree() )));
            whiteball.setY((int) (whiteball.getY()+15*Math.sin(whiteball.getDegree() )));
            whiteball.setSpeed(whiteball.getSpeed()-1);
        }else{
            gimage.drawLine(whiteball.getX()+20,20+whiteball.getY(),x_mouse,y_mouse);
            System.out.println("球杆");
        }
        gimage.drawImage(ball_white,whiteball.getX(),whiteball.getY() ,null);
        g.drawImage(off,0,0,null);


    }
}
