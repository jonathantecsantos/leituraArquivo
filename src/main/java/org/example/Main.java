package org.example;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\User\\Documents\\TesteLeitura\\In\\arquivo.txt";
        String destinationFolderPath = "C:\\Users\\User\\Documents\\TesteLeitura\\Out";

        try {
            // Lê os dados do arquivo e salva em uma variável
            byte[] fileData = readFile(sourceFilePath);

            // Copia o arquivo para a pasta de destino
            copyFile(sourceFilePath, destinationFolderPath);

            System.out.println("Arquivo lido e copiado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] fileData = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(fileData);
        fis.close();

        return fileData;
    }

    private static void copyFile(String sourceFilePath, String destinationFolderPath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File destinationFolder = new File(destinationFolderPath);

        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        String destinationFilePath = destinationFolderPath + "\\" + sourceFile.getName();
        File destinationFile = new File(destinationFilePath);

        FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(destinationFile);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();
    }
}