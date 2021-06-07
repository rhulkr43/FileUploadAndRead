package com.readdata.Helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadHelper {

	public final static String UPLOAD_DIR="D:\\apmosysFile";
    public boolean uploadcsv(MultipartFile multipartFile,String title){
        boolean status=false;
        try{
            File file=new File(UPLOAD_DIR+"\\"+title);
            if(!file.exists()){
                file.mkdirs();
            }
            String newpath=file.toString();

            Files.copy(multipartFile.getInputStream(), Paths.get(newpath+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            status=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
 }
}
