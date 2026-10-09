public class App {
    public static void main(String[] args) throws Exception {
        Image image = new Image ("colombia.bmp", 200, 150);
        image.createImage();
        image.printHeader();
    }
}
