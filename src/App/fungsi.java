/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LABKOM
 */
public class fungsi {
    static String folder = "aktivitas";
    static String home = System.getProperty("user.home");
    static String pathFolder = home + File.separator + folder;
    static String logName = "log.txt";
    static String pathLog = pathFolder + File.separator + logName;

    // Menambahkan method untuk mendapatkan format tanggal
    public static String getDateNow() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m:s z");
        return sdf.format(d);
    }

    // Memodifikasi savelog untuk menggunakan getDateNow
    public static void savelog(String activity) {
        try {
            File f = new File(pathFolder);
            f.mkdir();  // Membuat folder "aktivitas" jika belum ada

            File log = new File(pathLog);
            log.createNewFile();  // Membuat file "log.txt" jika belum ada

            String logEntry = "\n[" + getDateNow() + "] " + activity;

            Files.write(
                Paths.get(pathLog),
                logEntry.getBytes(),
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error Code: 101 => " + e.getMessage());
        }
    }
}