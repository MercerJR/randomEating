package com.project.random_eating.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mercer JR
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Integer code;
    private String message;
    private Object data;
    private boolean isok;

    public Response Success(Object data){
        Response response = new Response();
        response.setCode(200);
        response.setMessage("操作成功");
        response.setData(data);
        response.setIsok(true);
        return response;
    }

    public Response Success(){
        Response response = new Response();
        response.setCode(200);
        response.setMessage("操作成功");
        response.setIsok(true);
        return response;
    }

//    public Response Success(String message){
//        Response response = new Response();
//        response.setCode(200);
//        response.setMessage(message);
//        response.setIsok(true);
//        return response;
//    }

    public Response Failed(){
        Response response = new Response();
        response.setCode(500);
        response.setIsok(false);
        response.setMessage("操作失败");
        return response;
    }

    public Response Failed(String message){
        Response response = new Response();
        response.setCode(500);
        response.setIsok(false);
        response.setMessage(message);
        return response;
    }

    public Response ValidateFailed(){
        Response response = new Response();
        response.setCode(404);
        response.setMessage("参数校验失败");
        return response;
    }
}
