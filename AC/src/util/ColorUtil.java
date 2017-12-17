package util;
 
import java.awt.Color;
 
public class ColorUtil {
    public static Color blueColor = Color.decode("#35B0E1");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");
    public static Color whiteColor = Color.decode("#FFFFFF");
    public static Color blackColor = Color.decode("#000000");
 
    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r = 79;
        int g = 232;
        int b = 79;
        float rate = per / 100f;
        r = (int) ((232 - 79) * rate + 79);
        g = 232 - r + 79;
        Color color = new Color(r, g, b);
        return color;
    }
}