package com.danilo.qrcodegenerator.controller;

import com.danilo.qrcodegenerator.dto.QrCodeGenerateRequest;
import com.danilo.qrcodegenerator.dto.QrCodeGenerateResponse;
import com.danilo.qrcodegenerator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
        QrCodeGenerateResponse response;

        try {
            response = qrCodeGeneratorService.generateAndUploadQrCode(request);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(response);
    }

}
