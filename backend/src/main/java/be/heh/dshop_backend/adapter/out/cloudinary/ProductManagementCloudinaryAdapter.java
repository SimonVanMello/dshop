package be.heh.dshop_backend.adapter.out.cloudinary;

import be.heh.dshop_backend.common.UseCase;
import com.cloudinary.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

@UseCase
public class ProductManagementCloudinaryAdapter implements ProductManagementCloudinaryOut {
    @Override
    public String saveImage(byte[] image){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvrqjbqvd",
                "api_key", "993586641827343",
                "api_secret", "SOxneSHmgwpGR58qYqP4Z1LH-Ro",
                "secure", true));

        try{
            Map uploadResult = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
            return uploadResult.get("secure_url").toString();
        } catch (Exception e){
            return "Error uploading the image";
        }
    }
}
