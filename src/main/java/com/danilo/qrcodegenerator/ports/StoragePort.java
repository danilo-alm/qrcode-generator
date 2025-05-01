package com.danilo.qrcodegenerator.ports;

public interface StoragePort {

    String uploadFile(byte[] fileData, String fileName, String contentType);

}
