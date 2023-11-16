package be.heh.dshop_backend.adapter.out.cloudinary;

import be.heh.dshop_backend.common.UseCase;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import com.cloudinary.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import com.cloudinary.utils.ObjectUtils;

import java.util.Base64;
import java.util.Map;

@UseCase
public class ProductManagementCloudinaryAdapter implements ProductManagementCloudinaryOut {
    @Override
    public String saveImage(ProductManagementAddCommand command){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvrqjbqvd",
                "api_key", "993586641827343",
                "api_secret", "SOxneSHmgwpGR58qYqP4Z1LH-Ro",
                "secure", true
        ));

        try{
            Map uploadResult = cloudinary.uploader().upload(command.getImage(), ObjectUtils.asMap(
                    "public_id", Base64.getEncoder().encodeToString(command.getName().getBytes()),
                    "folder", "dshop/products"
            ));
            return uploadResult.get("secure_url").toString();
        } catch (Exception e){
            return "Error uploading the image";
        }
    }
}
