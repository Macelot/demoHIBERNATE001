package com.marcelot;

import java.awt.image.BufferedImage;

import generators.BarbecueBarcodeGenerator;
import generators.QRGenBarcodeGenerator;
import generators.ZxingBarcodeGenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/barcodes")
public class BarcodesController {
    //Barbecue library

    @GetMapping(value = "/barbecue/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueUPCABarcode(@PathVariable("barcode") String barcode) throws Exception {
        return okResponse(BarbecueBarcodeGenerator.generateUPCABarcodeImage(barcode));
    }

    @GetMapping(value = "/barbecue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception {
        return okResponse(BarbecueBarcodeGenerator.generateEAN13BarcodeImage(barcode));
    }

    @PostMapping(value = "/barbecue/code128", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueCode128Barcode(@RequestBody String barcode) throws Exception {
        return okResponse(BarbecueBarcodeGenerator.generateCode128BarcodeImage(barcode));
    }

    @PostMapping(value = "/barbecue/pdf417", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecuePDF417Barcode(@RequestBody String barcode) throws Exception {
        return okResponse(BarbecueBarcodeGenerator.generatePDF417BarcodeImage(barcode));
    }
    
    @PostMapping(value = "/zxing/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zxingQRCode(@RequestBody String barcode) throws Exception {
        return okResponse(ZxingBarcodeGenerator.generateQRCodeImage(barcode));
    }

    

    //QRGen
    //[POST] http://localhost:8080/barcodes/zxing/qrcode
    //http://localhost:8088/barcodes/qrgen/qrcode
    @PostMapping(value = "/qrgen/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrgenQRCode(@RequestBody String barcode) throws Exception {
        return okResponse(QRGenBarcodeGenerator.generateQRCodeImage(barcode));
    }

    private ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
