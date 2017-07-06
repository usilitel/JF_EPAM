package javase02_oop.t01;

public class Pen {
    private int price;
    private String model;

    public Pen(int price, String model) {
        this.price = price;
        this.model = model;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Pen pen = (Pen) obj;
        if (this.price != pen.price) {
            return false;
        }
        if (null == this.model) {
            return (null == pen.model);
        } else {
            if (!model.equals(pen.model)) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return (int) (31 * price + ((null == this.model) ? 0 : this.model.hashCode()));
    }

    public String toString() {
        return getClass().getName() + "@" + "price: " + price + ", model: " + model;
    }
}
