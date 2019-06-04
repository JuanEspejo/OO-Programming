public class Exam {
    public static void main(String[] args) {
        Maximizable[] maximizable = new Maximizable[4];
        maximizable[0] = new QuadraticCurve(1,-2,-3,0,2);
        maximizable[1] = new QuadraticCurve(-1,2,1,-1,1);
        maximizable[2] = new Factory(4,5,19,8,10,"gorra","polo","Gamarrita");
        maximizable[3] = new Factory(2,3,19,8,10,"banca","silla","Villa El Salvadorcito");
        for (Maximizable ref: maximizable)
            System.out.printf("%s\n%s\n\n", ref, ref.showMaximum());
    }
}


interface Maximizable {
    String showMaximum();
}


class QuadraticCurve implements Maximizable {
    private final double EPSILON = 0.0001D;
    private int a;
    private int b;
    private int c;
    private int x0;
    private int x1;

    public QuadraticCurve(int a, int b, int c, int x0, int x1) {
        if (a == 0)
            throw new IllegalArgumentException("Quadratic coefficient must be non-zero!");
        if (x0 >= x1)
            throw new IllegalArgumentException("Lower bond must be less than upper bound!");
        this.a = a;
        this.b = b;
        this.c = c;
        this.x0 = x0;
        this.x1 = x1;
    }

    public String showMaximum() {
        double aux = (double)-b/(2*a), xMax = 0;
        String string0 =
            String.format("The curve has ");
        if (a < 0) {
            if (x1 < aux || Math.abs(aux - x1) < EPSILON) xMax = x1;
            else if (aux < x0 || Math.abs(x0 - aux) < EPSILON) xMax = x0;
            else xMax = aux;
        }
        if (a > 0) {
            if (x1 < aux || Math.abs(aux - x1) < EPSILON) xMax = x0;
            else if(aux < x0 || Math.abs(x0 - aux) < EPSILON) xMax = x1;
            else {
                double delta =	x1 + x0 - 2*aux;
                if(Math.abs(delta) < EPSILON) {
                    String string1 =
                        String.format("two maxima: %d and %d.", x0, x1);
                    return string0 + string1;
                }
                else if(delta < 0) xMax = x0;
                else xMax = x1;
            }
        }
        String string1 =
            String.format("one maximum: %.2f.", xMax);
        return string0 + string1;
    }

    @Override
    public String toString() {
        String string0 =
            String.format("Quadratic curve (%d)x^2 + (%d)x + (%d) ", a, b, c);
        String string1 =
            String.format("over the domain [%d,%d].", x0, x1);
        return string0 + string1;
    }
}


class Factory implements Maximizable {
    private int costX;
    private int costY;
    private int investment;
    private int priceX;
    private int priceY;
    private String itemX;
    private String itemY;
    private String name;

    public Factory(int costX, int costY, int investment,
                   int priceX, int priceY,
                   String itemX, String itemY, String name) {
        if (costX <= 0 || costY <= 0 || priceX <= 0 || priceY <= 0)
            throw new IllegalArgumentException("Costs and prices must be positive!");
        if (investment < costX && investment < costY)
            throw new IllegalArgumentException("Insufficient investment!");
        this.costX = costX;
        this.costY = costY;
        this.investment = investment;
        this.priceX = priceX;
        this.priceY = priceY;
        this.itemX = itemX;
        this.itemY = itemY;
        this.name = name;
    }

    public String showMaximum() {
        int m = investment/costX;
        int xMax = 0, yMax = 0;
        int max = 0, k;
        for (int j = 0; j <= m; j++) {
            k = (investment - j*costX) / costY;
            if (j*priceX + k*priceY > max) {
                max = j*priceX + k*priceY;
                xMax = j;
                yMax = k;
            }
        }
        String string0 = "The factory has maximum production when produces";
        String string1 =
            String.format(" %d %s and %d %s.", xMax, itemX, yMax, itemY);
        return string0 + string1;
    }

    @Override
    public String toString() {
        String string0 =
            String.format("Factory %s\nInvestment: %d PEN\n", name, investment);
        String string1 =
            String.format("itemX: %s (cost: %d PEN, price: %d PEN)\n", itemX, costX, priceX);
        String string2 =
            String.format("itemY: %s (cost: %d PEN, price: %d PEN)", itemY, costY, priceY);
        return string0 + string1 + string2;
    }
}
