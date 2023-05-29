/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;

/**
 *
 * @author Kasun
 */
public class ScanQr {
public String qrOut(){
String qrout=null;
int count=1;
Webcam webcam = Webcam.getDefault();


while(count==1){
 // non-default (e.g. USB) webcam can be used too
webcam.open();

Result result = null;
BufferedImage image = null;

if (webcam.isOpen()) {
    if ((image = webcam.getImage()) == null) 
    {
        continue;
    }

    LuminanceSource source = new BufferedImageLuminanceSource(image);
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    try {
        result = new MultiFormatReader().decode(bitmap);
    } catch (NotFoundException e) {
        // fall thru, it means there is no QR code in image
    }
}

if (result != null) {
    count++;
    qrout= result.getText();
    webcam.close();
}
}
return(qrout);
}

}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
