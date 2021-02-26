public class Delay {
    static public void delay(int time){
        try { Thread.sleep (time); } catch (InterruptedException ex) {}
    }
}
