package com.example.lvm.Controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

 
@Controller
public class fileUploadController {

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String handFormUpload(@RequestParam("name") String name,
                                 @RequestParam("upload") List<MultipartFile> files,
                                 HttpServletRequest request) throws IOException {
        if (!files.isEmpty() && files.size() > 0) {
            for (MultipartFile f : files) {
                String filename = f.getOriginalFilename();
                String dirpath = request.getServletContext().getRealPath("/" + name);
                File file = new File(dirpath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String newfilename = name + UUID.randomUUID() + filename;
                f.transferTo(new File(dirpath + newfilename));

            }

        }
        return null;

    }
}
