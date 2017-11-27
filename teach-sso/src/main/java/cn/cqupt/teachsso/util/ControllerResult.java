package cn.cqupt.teachsso.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 教学平台自定义的响应结构
 *
 */
public class ControllerResult {
    private static ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;

    public static ControllerResult build(Integer status, String msg, Object data) {
        return new ControllerResult(status, msg, data);
    }

    public static ControllerResult ok(Object data) {
        return new ControllerResult(data);
    }

    public static ControllerResult ok() {
        return new ControllerResult(null);
    }

    public ControllerResult() {

    }

    public static ControllerResult build(Integer status, String msg) {
        return new ControllerResult(status, msg, null);
    }

    public ControllerResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ControllerResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为ControllerResult对象
     * @param jsonData json 数据
     * @param clazz ControllerResult对象中的object 类型
     * @return
     */
    public static ControllerResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if(clazz == null) {
                return MAPPER.readValue(jsonData, ControllerResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (IOException e) {
            // 写日志文件
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ControllerResult format(String json) {
        try {
            return MAPPER.readValue(json, ControllerResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ControllerResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
