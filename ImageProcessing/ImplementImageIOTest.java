import static org.junit.Assert.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
public class ImplementImageIOTest {

    @Test
    public void testcase1() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/1_blue_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/1.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelB(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase2() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/1_gray_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/1.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showGray(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase3() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/1_green_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/1.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelG(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase4() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/1_red_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/1.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelR(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase5() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/2_blue_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/2.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelB(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase6() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/2_gray_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/2.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showGray(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase7() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/2_green_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/2.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelG(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

    @Test
    public void testcase8() throws IOException {
        FileInputStream in = new FileInputStream("./bmptest/goal/2_red_goal.bmp");
        BufferedImage goal = ImageIO.read(in);
        ImplementImageIO io = new ImplementImageIO();
        Image image = io.myRead("./bmptest/2.bmp");
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Image result = processor.showChanelR(image);
        BufferedImage test = new BufferedImage(result.getWidth(null), result.getHeight(null), BufferedImage.TYPE_INT_BGR);
        test.getGraphics().drawImage(result, 0, 0, result.getWidth(null), result.getHeight(null), null);
        assertEquals(goal.getWidth(null), result.getWidth(null));
        assertEquals(goal.getHeight(null), result.getHeight(null));
        for (int i = 0; i < goal.getWidth(null); i++) {
            for (int j = 0; j < goal.getHeight(null); j++) {
                assertEquals(goal.getRGB(i, j), test.getRGB(i, j));
            }
        }
    }

}
