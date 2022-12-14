package com.zjut.entity;

import org.springframework.stereotype.Component;

/**
 * 封装 RPC 请求
 */
@Component
public class RpcRequest {
    private String requestId; // 请求的Id, 唯一标识该请求
    private String interfaceName; // 接口名称
    private String serviceVersion; // 版本
    private String methodName; // 方法名称
    private Class<?>[] parameterTypes; // 参数类型
    private Object[] parameters; // 具体参数

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String className) {
        this.interfaceName = className;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

}