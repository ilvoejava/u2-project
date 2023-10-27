import java.lang.Math;




public class    LinearEquation {
    private double x1;
    private double x2;
    private double y1;
    private double y2;




    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double roundToHundredth(double toRound) {
        toRound = (double) Math.round(toRound * 100.0) / 100;
        return toRound;
    }




    public double distance() {
        return (double) Math.round(Math.abs(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))) * 100 / 100);
    }


    public double slope() {
        double slope = (y2 - y1) / (x2 - x1);
        return slope;

    }


    public String decimalToFraction() {
        String str = Double.toString(slope());
        if (slope() % 2 == 0) {
            str = Double.toString((y2 - y1) / (x2 - x1));
            return str;
        }
        if (slope() % 2 > 0) {
            str = ((int) (y2 - y1) + "/" + (int) (x2 - x1));
            return str;
        }
        return str;
    }


    public double yIntercept() {
        return roundToHundredth(y1 - slope() * x1);
    }


    static private String convertDecimalToFraction(double x) {
        if (x < 0) {
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);




        return (int) h1 + "/" + (int) k1;
    }

    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "The point on the line is (" + xValue +", " + yValue + ")";
    }




    public String equation() {

        if (slope() < 0) {
            return "y = " + slope() + "x " + yIntercept();
        }

        if (yIntercept() < 0) {
            return ("y = " + (slope()) + "x - " + Math.abs(yIntercept()));
        }

        if (yIntercept() == 0) {
            return ("y = " + (slope()) + "x");
        }


        if (slope() == 0) {
            return ("y = " + yIntercept());
        }


        if (slope() == 1) {
            return ("y = " + "x + " + yIntercept());
        }



        if (slope() % 1 > 0) {
            return ("y = " + convertDecimalToFraction(slope()) + "x + " + yIntercept());
        }
        if (slope() % 1 == 0) {
            return ("y = " + (slope() + "x + " + yIntercept()));

        }
        if (slope() == -1) {
            return "y = " + "x + " + yIntercept();
        }


        return ("y = " + convertDecimalToFraction(slope()) + "x + " + yIntercept());
    }


    public String lineInfo() {
        return "The two points are: " + "(" + x1 + ", " + y1 + ") and" + " (" + x2 + ", " + y2 + ")\nThe equation of" +
                " the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() +
                "\nThe y-intercept of the line is: " + yIntercept() + "\nThe distance between the two points is " +
                distance();
    }




}
