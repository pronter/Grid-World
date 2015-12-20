import imagereader.IImageProcessor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

public class ImplementImageProcessor implements IImageProcessor {
    // show the red channel and return image
    public Image showChanelR(Image sourceImage) {
        ColorFilter redFilter = new ColorFilter(1);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.createImage(new FilteredImageSource(sourceImage.getSource(), redFilter));
        return img;
    }
    // show the green channel and return image
    public Image showChanelG(Image sourceImage) {
        ColorFilter greenFilter = new ColorFilter(2);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.createImage(new FilteredImageSource(sourceImage.getSource(), greenFilter));
        return img;
    }
    // show the blue channel and return image
    public Image showChanelB(Image sourceImage) {
        ColorFilter blueFilter = new ColorFilter(3);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.createImage(new FilteredImageSource(sourceImage.getSource(), blueFilter));
        return img;
    }
    // show the gray channel and return image
    public Image showGray(Image sourceImage) {
        ColorFilter grayFilter = new ColorFilter(4);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image img = toolKit.createImage(new FilteredImageSource(sourceImage.getSource(), grayFilter));
        return img;
    }
}

class ColorFilter extends RGBImageFilter {
    private int colorNum;
    public ColorFilter(int c) {
        colorNum = c;
        canFilterIndexColorModel = true;
    }
    // caculate the gray-rgb 
    public int filterRGB(int x, int y, int rgb) {
        if (colorNum == 1) {
            return (rgb & 0xffff0000);
        } else if (colorNum == 2) {
            return (rgb & 0xff00ff00);
        } else if (colorNum == 3) {
            return (rgb & 0xff0000ff);
        } else {
            int red = ((rgb & 0x00ff0000) >> 16);
            int green = ((rgb & 0x0000ff00) >> 8 );
            int blue = ((rgb & 0x000000ff));
            int gray = (int)(red * 0.299 + green * 0.587 + blue * 0.114);
            return (rgb & 0xff000000) + (gray << 16) + (gray << 8) + gray;
        }
    }
}

