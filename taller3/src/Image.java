import java.io.FileOutputStream;

public class Image {
    private byte[] header;
    private String fileName;
    private int width;
    private int height;
    private int imageSize;
    private int fileSize;
    private String fileType;
    private char resered1;
    private char resered2;
    private int dataBegin;
    private int headSize;
    private char layers;
    private char pixelSize;
    private int compresion;
    private int horizontalResolution;
    private int verticalResolution;
    private int colorTableSize;
    private int countMainColor;



    public Image(String fileName, int width, int height){
        header = new byte[54];
        this.fileName = fileName;
        this.width = width;
        this.height = height;
        imageSize = width * height *3;
        this.fileSize = imageSize + 54;
        fileType = "BM";
        resered1 = 0;
        resered2 = 0;
        dataBegin = 54;
        headSize = 40;
        layers = 1;
        pixelSize = 24; 
        compresion = 0;
        horizontalResolution = 0;
        verticalResolution = 0;
        colorTableSize = 0;
        countMainColor = 0;
    }

    public void setChar(int position, int value) {
        for (int i = 0; i < 2; i++) {
            header[position + i] = (byte) ((value >> (i * 8)) & 0xFF);
        }
    }

    public void setInteger(int position, int value) {
        for (int i = 0; i < 4; i++) {
            header[position + i] = (byte) ((value >> (i * 8)) & 0xFF);
        }
    }

    public void createHeader(){
        byte[] firmaBytes = fileType.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        header[0] = firmaBytes[0];
        header[1] = firmaBytes[1];
        setInteger(2, fileSize);
        setChar(6, resered1);
        setChar(8, resered2);
        setInteger(10,dataBegin);
        setInteger(14, headSize);
        setInteger(18, width);
        setInteger(22, height);
        setChar(26, layers);
        setChar(28, pixelSize);
        setInteger(30, compresion);
        setInteger(34, imageSize);
        setInteger(38, horizontalResolution);
        setInteger(42, verticalResolution);
        setInteger(46, colorTableSize);
        setInteger(50, countMainColor);
    }

    public void createImage() {
        createHeader();
        try ( FileOutputStream newFile = new FileOutputStream("data/" + fileName)) {
            newFile.write(header);
            int padding = (4 - (width * 3) % 4) % 4;
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) { 
                    if (i < (height/2) /2) {
                        newFile.write(46); 
                        newFile.write(16); 
                        newFile.write(200); 
                    } else{
                        if (i < 2 * (height/2) /2) {
                            newFile.write(135); 
                            newFile.write(48); 
                            newFile.write(0); 
                        } else {
                            newFile.write(0); 
                            newFile.write(205); 
                            newFile.write(255); 
                        } 
                    } 
                }
                for (int p = 0; p < padding; p++) {
                     newFile.write(0);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public int getInteger(int position) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (header[position + i] & 0xFF) << (i * 8);
        }
        return value;
    }

    public void printHeader() {
        
        System.out.println("File Type: " + new String(new byte[]{header[0], header[1]}));
        System.out.println("File Size: " + getInteger(2));
        System.out.println("Data Begin: " + getInteger(10));
        System.out.println("Header Size: " + getInteger(14));
        System.out.println("Width: " + getInteger(18));
        System.out.println("Height: " + getInteger(22));
    }


}
