package cz.tul.ssv;

public class Rectangle {
    
    protected int a;
    protected int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public int area() {
        return this.a * this.b;
    }

    @Override
    public String toString() {
        return String.format("<%s %d x %d>", this.getClass().getName(), this.a, this.b);
    }
}