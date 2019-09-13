
package circuit.designer.simon;


abstract public class Gate {
    
    protected static double xStart;
    protected static double yStart;
    
    public Gate(int x, int y){
        xStart = x;
        yStart = y;
    }
    
    //Getters & Setters
    public static double getxStart() {
        return xStart;
    }
    public static void setxStart(double xStart) {
        Gate.xStart = xStart;
    }
    public static double getyStart() {
        return yStart;
    }
    public static void setyStart(double yStart) {
        Gate.yStart = yStart;
    }
    
}
