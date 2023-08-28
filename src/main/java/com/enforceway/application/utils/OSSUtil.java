package com.enforceway.application.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.enforceway.application.constants.SystemConstant;

import java.io.*;
import java.net.URL;
import java.util.Date;

public class OSSUtil {

    public static void main(String[] args) {
        String folderPath = "D:\\espace\\practice\\contacts-manager\\src\\main\\resources\\static\\image";
        String fileName = "002.png";

//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File(folderPath + File.separator + fileName));
//            OSSUtil.uploadFile(SystemConstant.ALI_YUN_OSS_IMAGE_BUCKETNAME, "20230816/" + fileName, inputStream);
//
//        } catch(com.aliyuncs.exceptions.ClientException e) {
//            e.printStackTrace();
//        } catch(IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

        String imagePath = OSSUtil.getResourceByName(SystemConstant.ALI_YUN_OSS_IMAGE_BUCKETNAME, fileName);
        System.out.println("刚上传的图片地址是：" + imagePath);
    }

    public static String getResourceByName(String bucketName, String resourceName) {

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
//        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "phonebook-image";
        // 填写Object完整路径。Object完整路径中不能包含Bucket名称。
//        String objectName = "001.png";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
            SystemConstant.ALI_YUN_OSS_ENDPOINT,
            SystemConstant.ALI_YUN_OSS_USER_ACCESSKEY_ID,
            SystemConstant.ALI_YUN_OSS_USER_ACCESSKEY_SECRET);
        String objectPath = null;
        try {
            // 将图片缩放为固定宽高100 px后，再旋转90°。
            String style = "image/resize,m_fixed,w_100,h_100";
            // 指定签名URL过期时间为10分钟。
            Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
            GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, resourceName, HttpMethod.GET);
            req.setExpiration(expiration);
            req.setProcess(style);
            URL signedUrl = ossClient.generatePresignedUrl(req);
            objectPath = signedUrl.toString();
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return objectPath;
    }

    public static void uploadFile(String bucketName, String resourceName, InputStream fileInputStream) throws com.aliyuncs.exceptions.ClientException {
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
//        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
//        String objectName = "20230816/" + fileNameWithExtensionName;
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
            SystemConstant.ALI_YUN_OSS_ENDPOINT,
            SystemConstant.ALI_YUN_OSS_USER_ACCESSKEY_ID,
            SystemConstant.ALI_YUN_OSS_USER_ACCESSKEY_SECRET
        );

        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, resourceName, fileInputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
