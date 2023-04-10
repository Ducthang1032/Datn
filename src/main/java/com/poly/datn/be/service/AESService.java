package com.poly.datn.be.service;

import com.poly.datn.be.config.AuthConfig;
import com.poly.datn.be.enums.MetaData;
import com.poly.datn.be.errors.EncodingDataInvalidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class AESService {

    private final AuthConfig authConfig;

    /**
     * @param encryptData: Any String
     * @return String base64 decrypt with (key + stringInput)
     */
    public String decryptData(String encryptData) {
        try {
            byte[] key = authConfig.getCipherSecretKey().getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    secretKeySpec,
                    new IvParameterSpec(authConfig.getCipherSecretKey().substring(0, 16).getBytes(StandardCharsets.UTF_8)));

            byte[] original = cipher.doFinal(Base64.getUrlDecoder().decode(encryptData.getBytes()));
            return new String(original).trim();
        } catch (Exception ex) {
            throw new EncodingDataInvalidException(MetaData.INPUT_ENCODING_DATA_INVALID.getMessage());
        }
    }

    /**
     * @param stringData: Any String
     * @return String base64 encrypt with (key + stringInput)
     */
    public String encryptData(String stringData) {
        try {
            byte[] key = authConfig.getCipherSecretKey().getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    secretKeySpec,
                    new IvParameterSpec(authConfig.getCipherSecretKey().substring(0, 16).getBytes(StandardCharsets.UTF_8)));

            byte[] original = Base64.getUrlEncoder().encode(cipher.doFinal(stringData.getBytes(StandardCharsets.UTF_8)));
            return new String(original);
        } catch (Exception ex) {
            log.warn("Error when encrypt data: {}", stringData, ex);
            return null;
        }
    }

    /**
     * @param encryptData: String without encode url. ex: password, login, biometric, register....
     * @return String base64 decrypt with (key + stringInput)
     */
    public String decryptDataWithoutUrl(String encryptData) {
        try {
            byte[] key = authConfig.getCipherSecretKey().getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    secretKeySpec,
                    new IvParameterSpec(authConfig.getCipherSecretKey().substring(0, 16).getBytes(StandardCharsets.UTF_8)));

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptData.getBytes()));
            return new String(original).trim();
        } catch (Exception ex) {
            throw new EncodingDataInvalidException(MetaData.INPUT_ENCODING_DATA_INVALID.getMessage());
        }
    }

    /**
     * @param stringData: Any String
     * @return String base64 encrypt with (key + stringInput)
     */
    public String encryptWithoutUrl(String stringData) {
        try {
            byte[] key = authConfig.getCipherSecretKey().getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    secretKeySpec,
                    new IvParameterSpec(authConfig.getCipherSecretKey().substring(0, 16).getBytes(StandardCharsets.UTF_8)));

            byte[] original = Base64.getEncoder().encode(cipher.doFinal(stringData.getBytes(StandardCharsets.UTF_8)));
            return new String(original);
        } catch (Exception ex) {
            log.warn("Error when encrypt data: {}", stringData, ex);
            return null;
        }
    }
}
