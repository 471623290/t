public class ball {
    private int x,y,speed;
    private  double degree;
    private boolean live;
    /*
        横纵速度 是否存货
    */
    public ball(int x, int y, int speed, boolean live) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.live = live;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }


    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
