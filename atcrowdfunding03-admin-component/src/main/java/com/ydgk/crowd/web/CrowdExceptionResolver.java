package com.ydgk.crowd.web;

import com.google.gson.Gson;
import com.ydgk.crowd.constant.CrowdConstant;
import com.ydgk.crowd.util.ResultEntity;
import com.ydgk.crowd.util.UtilCrowd;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CrowdExceptionResolver {
  private ModelAndView commonResolveException(
          Exception exception,
          HttpServletRequest request,
          HttpServletResponse response,
          String viewName
  ) throws IOException {
// 判断是普通请求还是ajax请求
      boolean judgeRequestType = UtilCrowd.judgeRequestType(request);
      //如果是ajax请求
      if (judgeRequestType){
          String message=exception.getMessage();
          //创建resultemity
          ResultEntity<Object> failed= ResultEntity.failed(message);
          // 4、使用Gson进行解析ResultEntity对象拿到JSON串，写入响应中
          // 创建Gson对象
          Gson gson = new Gson();

          // 5、使用gson对象转换ResultEntity
          String jsonStr = gson.toJson(failed);

          // 6、 通过 Response对象将 jsonStr 写入响应中  获取writer对象
          PrintWriter writer = null;
          try {
              writer = response.getWriter();
          } catch (IOException e) {
              e.printStackTrace();
          }
          // 7、正式写入
          writer.write(jsonStr);
          // 8、设置响应类型
          response.setContentType("application/json");
          // 如果返回的是一个null SpringMVC会认为是自己给出了响应，不再使用SpringMVC提供的响应方法。
          return null;
      }
      // 表示不是一个 Ajax 请求
      // 9、需要将异常信息存入模型对象中，给出一个对应的错误视图
      // 创建ModelAndView对象
      ModelAndView modelAndView = new ModelAndView();
      // 10、将错误消息传入模型中
      modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,exception);
      // 11、 设置响应的视图
      modelAndView.setViewName(viewName);
      // 12、返回ModelAndView对象
      return modelAndView;



  }
}
