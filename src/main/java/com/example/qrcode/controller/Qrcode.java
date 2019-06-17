package com.example.qrcode.controller;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/qrcode")
public class Qrcode {
    @GetMapping(value = "getQrcode",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getQrcode(){
        ByteArrayOutputStream stream = QRCode.from("http://www.baidu.com")
                .withSize(256,256)
                .to(ImageType.PNG)
                .withErrorCorrection(ErrorCorrectionLevel.H)
                .stream();
        byte[] bytes = stream.toByteArray();

        return bytes;
    }
}
