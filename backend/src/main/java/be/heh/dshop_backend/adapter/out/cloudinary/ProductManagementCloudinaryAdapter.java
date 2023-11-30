package be.heh.dshop_backend.adapter.out.cloudinary;

//import be.heh.dshop_backend.common.UseCase;
import be.heh.dshop_backend.core.port.in.ProductManagementAddCommand;
import com.cloudinary.*;
import be.heh.dshop_backend.core.port.out.ProductManagementCloudinaryOut;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.util.Map;

//@UseCase
public class ProductManagementCloudinaryAdapter implements ProductManagementCloudinaryOut {
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dvrqjbqvd",
            "api_key", "993586641827343",
            "api_secret", "SOxneSHmgwpGR58qYqP4Z1LH-Ro",
            "secure", true
    ));

    @Override
    public String saveImage(ProductManagementAddCommand command){
        try{
            Map uploadResult = this.cloudinary.uploader().upload(command.getImage(), ObjectUtils.asMap(
                    "public_id", DigestUtils.md5Hex(command.getName()).toUpperCase(),
                    "folder", "dshop/products"
            ));
            return uploadResult.get("secure_url").toString();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteImage(String productName){
        try {
            final String hashedProductName = DigestUtils.md5Hex(productName).toUpperCase();
            final String imagePath = "dshop/products/" + hashedProductName;
            Map response = this.cloudinary.uploader().destroy(imagePath, ObjectUtils.emptyMap());
            return response.get("result").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
