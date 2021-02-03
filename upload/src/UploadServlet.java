import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-06 20:58
 */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断上传的数据是否是多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每一个表单项
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                //遍历表单项，判断是普通数据，还是上传的文件
                for (FileItem item : fileItems) {

                    if(item.isFormField()){//普通数据
                        System.out.println(item.getFieldName());
                        System.out.println(item.getString("UTF-8"));
                    }else{//上传的文件
                        System.out.println(item.getFieldName());
                        System.out.println(item.getName());
                        item.write(new File("C:\\Users\\王虎\\Desktop\\" + item.getName()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
