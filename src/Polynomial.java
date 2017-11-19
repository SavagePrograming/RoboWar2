import javax.swing.*;
import java.util.ArrayList;

public class Polynomial {
    double[] Coeffeicents;

    public static void main(String[] args) {
        Polynomial p = new Polynomial(new double[] {1, -1, 1, -2, 1});
        for (int i = 0; i < 3; i++){
            System.out.println(p);
            double[] roots = new double[0];
            double time = System.nanoTime();
            for (int ii = 0; ii < 100; ii++){
                roots = p.getRootsInRange(0.0, 5.0, .0001);
            }
            System.out.println(System.nanoTime() - time);
            for (double d:roots){
                System.out.print(d + " ");
            }
            System.out.println();
            p = new Polynomial(p.getDirivitive());


        }


    }



//    static double[] findRoots(double[] Coeffeicents, int Start, int End){
//
//    }

    static double[] getDirivitive(double[] Coeffeicents){
        double[] newCoeffeicents = new double[Coeffeicents.length - 1];
        for (int i = 1; i < Coeffeicents.length; i ++){
            newCoeffeicents[i - 1] = i * Coeffeicents[i];
        }
        return newCoeffeicents;
    }

    public double[] getDirivitive(){
        return getDirivitive(this.Coeffeicents);
    }

    public Polynomial(double[] Coeffeicents){
        this.Coeffeicents = Coeffeicents;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.Coeffeicents.length; i ++){

            if (i != 0){
                if (this.Coeffeicents[i] < 0){
                    str += " - " + this.Coeffeicents[i] + "x^" + i;
                }else{
                    str += " + " + this.Coeffeicents[i] + "x^" + i;
                }
            } else{
                str += "" + this.Coeffeicents[i];
            }
        }
        return str;
    }

    public static double[] getQuadradicRoots(double[] Coeffeicents){
        double a = Coeffeicents[0];
        double b = Coeffeicents[1];
        double c = Coeffeicents[2];
        if (Math.pow(b, 2.0) - 4 * a * c >= 0){
            return new double[] {(b - Math.sqrt(Math.pow(b, 2.0) - 4 * a * c))/ ( 2.0 * a),
                    (b + Math.sqrt(Math.pow(b, 2.0) - 4 * a * c))/ ( 2.0 * a)};
        }else{
            return new double[0];
        }

    }

    public static double[] getLinearRoots(double[] Coeffeicents){
        return new double[] {-Coeffeicents[0]/Coeffeicents[1]};

    }

    public double[] getRootsInRange(double start, double end, double precision){
        return getRootsInRange(this.Coeffeicents, start, end, precision);
    }

    public static double[] getRootsInRange(double[] Coeffeicents, double start, double end, double precision){
        if (Coeffeicents.length <= 1){
            return new double[0];
        }else if (Coeffeicents.length == 2) {
            double[] out = getLinearRoots(Coeffeicents);
            return clean(out, start, end);

        }else if (Coeffeicents.length == 3) {
            double[] out = getQuadradicRoots(Coeffeicents);
            return clean(out, start, end);
        }else {
            double[] out = getRootsInRange(getDirivitive(Coeffeicents), start, end, precision);
            double[] points = new double[out.length + 2];
            for (int i = 0; i < out.length; i ++) points[i + 1] = out[i];
            points[0] = start;
            points[points.length - 1] = end;
            ArrayList<Double> roots = new ArrayList<>();
            for (int i = 0; i + 1 < points.length; i ++) addRoot(Coeffeicents, points[i], points[i + 1], precision, roots);
            out = new double[roots.size()];
            for (int i = 0; i < out.length; i ++) out[i] = roots.get(i);
            return out;
        }
    }

    private static void addRoot(double[] Coeffeicents, double start, double end, double precision, ArrayList<Double> roots){
        double startValue = evaluate(Coeffeicents, start);
        double endValue = evaluate(Coeffeicents, end);
//        System.out.println("|"+startValue + " " + endValue+"|");
        if (startValue * endValue < 0){
            if (startValue < endValue){
                roots.add(binarySearch(Coeffeicents, start, end, precision));

            }else{
                roots.add(binarySearch(Coeffeicents, end, start, precision));
            }

        }else if (endValue == 0){
            roots.add(end);
        }

    }

    private static double binarySearch(double[] Coeffeicents, double start, double end, double precision){
        double guess = (start + end) / 2.0;
        double guessValue = evaluate(Coeffeicents, guess);
        while (Math.abs(guessValue) > precision){
            if (guessValue > 0){
//                        endValue  = guessValue;
                end = guess;
                guess = (start + end) / 2.0;
                guessValue = evaluate(Coeffeicents, guess);

            }else{
                start = guess;
                guess = (start + end) / 2.0;
                guessValue = evaluate(Coeffeicents, guess);
            }
        }
        return guess;
    }

    public static double evaluate(double[] Coeffeicents, double x){
        double sum = 0;
        for (int i = 0; i < Coeffeicents.length; i++){
            sum += Coeffeicents[i] * Math.pow(x, i);
        }
        return sum;
    }

    public double evaluate(double x){
        return evaluate(this.Coeffeicents, x);
    }


    private static double[] clean(double[] roots, double start, double end){
        int count = 0;
        for (double o: roots) if (o > start && 0 <= end) count ++;
        double[] OUT = new double[count];
        count = 0;
        for (double o: roots){
            if (o > start && 0 <= end){
                OUT[count] = o;
                count++;
            }
        }
        return OUT;
    }



}




