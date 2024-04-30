package net.liangyihui.manager.kypt.bos.controller;

import net.liangyihui.digitalmarketing.constant.ErrorCodeConstant;
import net.liangyihui.digitalmarketing.response.CommonResponse;
import net.liangyihui.digitalmarketing.storage.FileAddResult;
import net.liangyihui.digitalmarketing.storage.FileStorage;
import net.liangyihui.digitalmarketing.storage.exception.UploadFileFailedException;
import net.liangyihui.digitalmarketing.utils.DateUtils;
import net.liangyihui.manager.kypt.bos.api.response.common.FileUploadResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "file")
public class FileController extends AbstractBaseController{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileStorage fileStorage;


    @PostMapping("/upload")
    public CommonResponse upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            logger.warn("file upload failed ,reason file is empty");
            return new CommonResponse(CommonResponse.FAILED,"file is empty");
        }

        String filePath = DateUtils.dateFormat(new Date());
        String fileName = UUID.randomUUID().toString();
        String originalFileName = file.getOriginalFilename();
        String extesion = originalFileName.substring(originalFileName.lastIndexOf("."));
        if(StringUtils.isNoneBlank(extesion)){
            fileName = fileName.concat(extesion);
        }
        String aPath = fileStorage.getAbsolutePath(filePath,fileName);
        try {
            FileAddResult fileAddResult = fileStorage.addFile(aPath,file.getInputStream());
            if(logger.isDebugEnabled()){
                logger.debug("succ to upload");
            }
            return CommonResponse.succ(new FileUploadResponse(fileAddResult.getPath(),originalFileName));
        } catch (IOException e) {
            logger.error("failed to upload file",e);
            return CommonResponse.failed(ErrorCodeConstant.COMMON_FILE_UPLOAD_FAILED,getMessage(ErrorCodeConstant.COMMON_FILE_UPLOAD_FAILED));
        }catch(UploadFileFailedException uploadFileFailedException){
            logger.error("failed to upload",uploadFileFailedException);
            return CommonResponse.failed(ErrorCodeConstant.COMMON_FILE_UPLOAD_FAILED,getMessage(ErrorCodeConstant.COMMON_FILE_UPLOAD_FAILED));
        }
    }
}
