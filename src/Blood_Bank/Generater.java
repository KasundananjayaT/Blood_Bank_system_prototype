/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import Forms.DB.BasicDD;
import Forms.DB.FPage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kasun
 */
public class Generater {
    public void generateQr(String DID)
    {
    try{
    String QrCodeData=DID;
    String filePath= "C:\\Users\\Yello\\OneDrive - University of Kelaniya\\Desktop\\Qr.png";
    String charset= "UTF-8";
    Map <EncodeHintType,ErrorCorrectionLevel> hintMap= new EnumMap <> (EncodeHintType.class);
    hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    BitMatrix  matrix= new MultiFormatWriter().encode(
    new String (QrCodeData.getBytes(charset),charset),
    BarcodeFormat.QR_CODE,200,200,hintMap);
    
    MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.')+1),new File(filePath));
        System.out.println("Qr code has been generated at the location "+filePath);

JFrame frame = new JFrame();
ImageIcon icon = new ImageIcon("C:\\Users\\Yello\\OneDrive - University of Kelaniya\\Desktop\\Qr.png");
JLabel label = new JLabel(icon);
JButton button = new JButton("Print QR");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        JOptionPane.showMessageDialog(frame, "Print Successfully");
        frame.dispose();
        
    }
});
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
panel.add(label, BorderLayout.CENTER);
panel.add(button, BorderLayout.SOUTH);
frame.add(panel);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocationRelativeTo(null); // centers the frame
frame.setVisible(true);

    }
    catch(Exception e){
        System.out.println(e);
    
    }
    
    }   
    public void generateQr(String DID,String p)
    {
    try{
    String QrCodeData=DID;
    String filePath= "C:\\Users\\Yello\\OneDrive - University of Kelaniya\\Desktop\\Qr1.png";
    String charset= "UTF-8";
    Map <EncodeHintType,ErrorCorrectionLevel> hintMap= new EnumMap <> (EncodeHintType.class);
    hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    BitMatrix  matrix= new MultiFormatWriter().encode(
    new String (QrCodeData.getBytes(charset),charset),
    BarcodeFormat.QR_CODE,200,200,hintMap);
    
    MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.')+1),new File(filePath));
        System.out.println("Qr code has been generated at the location "+filePath);

JFrame frame = new JFrame();
ImageIcon icon = new ImageIcon("C:\\Users\\Yello\\OneDrive - University of Kelaniya\\Desktop\\Qr1.png");
JLabel label = new JLabel(icon);
JButton button = new JButton("Print QR");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        JOptionPane.showMessageDialog(frame, "Print Successfully");
        frame.dispose();
        
    }
});
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
panel.add(label, BorderLayout.CENTER);
panel.add(button, BorderLayout.SOUTH);
frame.add(panel);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocationRelativeTo(null); // centers the frame
frame.setVisible(true);

    }
    catch(Exception e){
        System.out.println(e);
    
    }
    
    }   
}

