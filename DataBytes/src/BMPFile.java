import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BMPFile {
    private byte[] header;
    private String filePath;

    public BMPFile(String filePath) {
        this.filePath = filePath;
        this.header = new byte[54]; 
    }

    public int getInteger(int position) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (header[position + i] & 0xFF) << (i * 8);
        }
        return value;
    }

    public void setInteger(int position, int value) {
        for (int i = 0; i < 4; i++) {
            header[position + i] = (byte) ((value >> (i * 8)) & 0xFF);
        }
    }

    public void readHeader() {
        try (FileInputStream stream = new FileInputStream(filePath)) {
            stream.read(header);
        } catch (java.io.IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }



    public void createNewBMPFile(){
        readHeader();
        int fileSize = getInteger(2);
        int width = getInteger(18);
        int height = getInteger(22);
        int newWidth = width / 2;
        int newHeight = height;
        int newFileSize = newWidth * newHeight * 3 + 54;
        setInteger(2, newFileSize);
        setInteger(18, newWidth);
        setInteger(22, newHeight);
        copyFile(newWidth, newHeight);
    }

    public void printHeaderInfo() {
        System.out.println("File Type: " + new String(new byte[]{header[0], header[1]}));
        System.out.println("Tamaño del archivo: " + getInteger(2));
        System.out.println("Ancho de la imagen: " + getInteger(18));
        System.out.println("Alto de la imagen: " + getInteger(22));
        System.out.println("Número de bits por píxel: " + getInteger(28));
    }

    public void copyFile(int newWidth, int newHeight) {
        try (FileInputStream file = new FileInputStream(filePath);
            FileOutputStream copyfile = new FileOutputStream("data/file.bmp")) {
            copyfile.write(header);
            file.skip(54);
            int numRows = newHeight*3;
            byte[] copyBodyImg = new byte[(newWidth * 3)];
            for (int i = 0; i < numRows; i++) {
                file.read(copyBodyImg);
                copyfile.write(copyBodyImg);
                file.skip(newWidth * 3);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
