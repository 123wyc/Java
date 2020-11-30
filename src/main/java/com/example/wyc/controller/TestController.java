package com.example.wyc.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController()
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/test1")
    public String TestController(){

        return "Success";
    }

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String ImageController(HttpServletRequest request){

        String url = request.getParameter("url");
        System.out.println(url);
        ImageData imageData = new ImageData();
        byte[] img= Base64.getDecoder().decode(url.substring(22));
        imageData.setByteArray(img);
        imageData.setName("this is a test");


        List<ImageData> list = new ArrayList<ImageData>();
        list.add(imageData);
        String fileName = "C:\\Users\\pc\\Desktop\\demo.xlsx";
        EasyExcel.write(fileName, ImageData.class).sheet().doWrite(list);
        return "";
    }
    @RequestMapping(value = "/image2",method = RequestMethod.POST)
    public String Image2(HttpServletRequest request, HttpServletResponse response,MultipartFile[] files) throws IOException {
        String fileName = "C:\\Users\\pc\\Desktop\\demo.xlsx";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=model.xlsx");
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        String id = request.getParameter("id");
        System.out.println(id);
        List<ImageData> list = new ArrayList<>();
        if (null!=files){
            for(MultipartFile file :files){
                ImageData imageData = new ImageData();
                byte[] img= file.getBytes();
                imageData.setByteArray(img);
                imageData.setName(file.getName());
                list.add(imageData);
            }
        }


        WriteSheet sheet1 = EasyExcel.writerSheet(1).head(ImageData.class).build();
        excelWriter.write(list,sheet1);

        Person person = new Person();
        person.setAge(11);
        person.setJob("coder");
        person.setName("cwl");
        List<Person> list2 = new ArrayList<>();
        list2.add(person);
        WriteSheet sheet2 = EasyExcel.writerSheet(2).head(Person.class).build();
        excelWriter.write(list2,sheet2);
        excelWriter.finish();

        //EasyExcel.write(response.getOutputStream()).sheet(1).head(ImageData.class).doWrite(list);
        //EasyExcel.write(fileName, ImageData.class).sheet().doWrite(list);

        return "";
    }

}
@ContentRowHeight(1000)
class ImageData {
//    private File file;
//    private InputStream inputStream;
    /**
     * 如果string类型 必须指定转换器，string默认转换成string
     */
/*    @ExcelProperty(converter = StringImageConverter.class)
    private String string;*/
    @ColumnWidth(100)
    @ExcelProperty(value = "Image")
    private byte[] byteArray;

    @ColumnWidth(20)
    @ExcelProperty(value = "Name")
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

@ContentRowHeight(20)
class Person{
    @ColumnWidth(20)
    @ExcelProperty(value = "Name")
    private String name;

    @ColumnWidth(20)
    @ExcelProperty(value = "Age")
    private int age;

    @ColumnWidth(20)
    @ExcelProperty(value = "Job")
    private String job;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}