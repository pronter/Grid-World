import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import imagereader.IImageIO;
import java.io.IOException;

public class ImplementImageIO implements IImageIO  {
    Image img;
    //read information from image
    public Image myRead(String p) throws IOException {
        File file = new File(p);
        //create a FileInputStream
        FileInputStream fis = new FileInputStream(file);
        //create byte array to store bmpHead and bmpInfo
        byte[] bmpHead = new byte[14];
        byte[] bmpInfo = new byte[40];
        fis.read(bmpHead, 0, 14);
        fis.read(bmpInfo, 0, 40);
        //read bmpInfo[20]-[23], it is pixels' bytes
        int size = transfrom(bmpInfo, 20, 4);
        //read bmpInfo[4]-[7], it is bmpWidth
        int width = transfrom(bmpInfo, 4, 4);
        //read bmpInfo[8]-[11], it is bmpHeight
        int height = transfrom(bmpInfo, 8, 4);
        //read bmpInfo[14]-[15], store every pixel's bits, check if bmp is 24bits
        int bits = transfrom(bmpInfo, 14, 2);
        if (bits == 24) {
            //caculate line supplement size
            int emptyByte = size / height - 3 * width;
            if (emptyByte == 4) {
                emptyByte = 0;
            }
            //define array store pixel from left to right, from down to up
            int temp = 0;
            int pixelArray[] = new int [width * height];
            byte bytes[] = new byte[size];
            fis.read(bytes, 0, size);
            for (int i = height-1; i >= 0; i--) {
                for (int j = 0; j < width; j++) {
                    //the first 0xff << 24 means transparency
                    pixelArray[ width * i + j ] = 0xff << 24
                            | (bytes[temp+2] & 0xff) << 16 
                            | (bytes[temp+1] & 0xff) << 8 
                            | (bytes[temp] & 0xff);
                    temp += 3;
                }
                temp += emptyByte;
            }
            img = Toolkit.getDefaultToolkit().createImage((ImageProducer) new MemoryImageSource(width, height, pixelArray, 0, width));
        }
        fis.close();
        return img;
    }
    //write image into .bmp
    public Image myWrite (Image img, String p) throws IOException {
        File a = new File(p);
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        buffer.getGraphics().drawImage(img, 0, 0, width, height, null);
        ImageIO.write(buffer, "bmp", a);
        return img;
    }
    // make byte transfrom in int
    public int transfrom(byte[] temp, int i, int num){
        int result = 0;
        for (int j = 0; j < num; j++) {            
            result = (result | (((int)temp[i+j] & 0xff) << 8*j));
        }
        return (result);
    }


}
