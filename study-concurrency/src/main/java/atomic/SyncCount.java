
package atomic;

public class SyncCount {

    private int num = 0;

    public synchronized int add() {
        return num++;
    }

    public int getNum() {
        return num;
    }
}
