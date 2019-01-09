package utils.Bitwise;

public class BitwiseUtil {
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
}
