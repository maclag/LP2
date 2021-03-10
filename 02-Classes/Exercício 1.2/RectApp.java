public class RectApp {
    public static void main(String[] args) {
        Rect r1 = new Rect(1, 1, 10, 10);
        r1.print();

        System.out.printf("\nMudanças\n---------\nÁrea = %d\n", r1.area());
        r1.drag(3, 3);
        r1.print();
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print() {
        System.out.printf("Retângulo de tamanho (%d,%d) na posição (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

    int area() {
        return this.w * this.h;
    }

    void drag(int dx, int dy) {
        this.x += dx; this.y += dy;
    }
}