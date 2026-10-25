import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// Counts the vertical black lines in a black and white JPG image
// Usage: java VerticalLineCounter "C:\path\to\image.jpg"
public class VerticalLineCounter {

    // Pixels with lower brightness count as black
    // Compression creates grey pixels, cannot check for pure black
    private static final int BLACK_THRESHOLD = 128;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Needs exactly ONE argument");
            System.out.println("Usage: java VerticalLineCounter \"C:\\path\\to\\image.jpg\"");
            return;
        }

        // Catching every exception that would crash the app
        try {
            File file = new File(args[0]);
            if (!file.isFile()) {
                System.out.println("Error: File not found");
                return;
            }

            // ImageIO returns null if file is not an image
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                System.out.println("Error: File is not a readable image");
                return;
            }

            System.out.println(countVerticalLines(image));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Every line crosses from the top half into the bottom half
    // So every line must cross the middle row
    // Scan row left to right to count each separate run of black pixels as one line
    static int countVerticalLines(BufferedImage image) {
        int middleRow = image.getHeight() / 2;
        int lineCount = 0;
        boolean previousWasBlack = false;

        for (int x = 0; x < image.getWidth(); x++) {
            boolean currentIsBlack = isBlack(image.getRGB(x, middleRow));

            // A new line starts when we hit black after white 
            // Or black at the very first pixel (handles lines touching the left edge)
            if (currentIsBlack && !previousWasBlack) {
                lineCount++;
            }
            previousWasBlack = currentIsBlack;
        }
        return lineCount;
    }

    // Average RGB to get pixel brightness
    private static boolean isBlack(int rgb) {
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return (red + green + blue) / 3 < BLACK_THRESHOLD;
    }
}
