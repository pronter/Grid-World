import imagereader.Runner;
public class ImageReaderRunner {
    public static void main(String args[]) {
        ImplementImageIO imageIO = new ImplementImageIO();
        ImplementImageProcessor processor = new ImplementImageProcessor();
        Runner.run(imageIO, processor);
    }
}
