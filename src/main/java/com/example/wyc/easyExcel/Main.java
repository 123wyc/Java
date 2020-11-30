package com.example.wyc.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        String fileName = "C:\\Users\\pc\\Desktop\\demo.xlsx";
        // 如果使用流 记得关闭
        InputStream inputStream = null;

        try {
            List<ImageData> list = new ArrayList<ImageData>();
            ImageData imageData = new ImageData();
            list.add(imageData);
            String imagePath = "C:\\Users\\pc\\Desktop\\1605345741(1).png";
            // 放入五种类型的图片 实际使用只要选一种即可
            imageData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));
            //imageData.setFile(new File(imagePath));
            //imageData.setString(imagePath);
            inputStream = FileUtils.openInputStream(new File(imagePath));
            imageData.setName("这是一个测试用例");
            //imageData.setInputStream(inputStream);
//            imageData.setUrl(new URL(
//                    "https://raw.githubusercontent.com/alibaba/easyexcel/master/src/test/resources/converter/img.jpg"));
            EasyExcel.write(fileName, ImageData.class).sheet().doWrite(list);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


@ContentRowHeight(1000)
@ColumnWidth(100 / 2)
class ImageData {
//    private File file;
//    private InputStream inputStream;
    /**
     * 如果string类型 必须指定转换器，string默认转换成string
     */
/*    @ExcelProperty(converter = StringImageConverter.class)
    private String string;*/
    private byte[] byteArray;

    @ExcelProperty(value = "测试")
    private String name;
    /**
     * 根据url导出
     *
     * @since 2.1.1
     */


//    public String getString() {
//        return string;
//    }
//
//    public void setString(String string) {
//        this.string = string;
//    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}