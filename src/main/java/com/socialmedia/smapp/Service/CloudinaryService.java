package com.socialmedia.smapp.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Configuration
public class CloudinaryService {

    @Value("${cloudinary.apikey}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Value("${cloudinary.cloudname}")
    private String cloudName;

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
        System.out.println(uploadResult.toString());
        return (String) uploadResult.get("url");  // Return the URL of the uploaded image
    }

}
