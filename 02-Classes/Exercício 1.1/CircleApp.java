class Circle {
    int centerX;
    int centerY;
    int radius;
    int r, g, b;

    Circle (int centerX, int centerY, int radius, int r, int g, int b) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    void print() {
        System.out.printf("O círculo possui centro no ponto (%d,%d) e raio igual a %d.\n", this.centerX, this.centerY, this.radius);
        System.out.printf("Sua coloração RGB é igual a (%d, %d, %d).\n", this.r, this.g, this.b);
    }
}

public class CircleApp {
    public static void main(String[] args) {
        Circle c1 = new Circle(2, 2, 3, 231, 148, 148);
        c1.print();
    }
}
