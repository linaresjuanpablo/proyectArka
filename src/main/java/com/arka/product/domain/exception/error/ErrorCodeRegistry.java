package com.arka.product.domain.exception.error;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ErrorCodeRegistry {

    private static final Map<String, IErrorCode> errorCodeMap = new HashMap<>();

    static {
        for(CommonErrorCode errorCode : CommonErrorCode.values()){
            register(errorCode);
        }
    }

    public static void register(IErrorCode errorCode){
        if (errorCodeMap.containsKey(errorCode.getCode())){
            throw new IllegalArgumentException("Error code" + errorCode.getCode() + "is already registered");
        }
        errorCodeMap.put(errorCode.getCode(), errorCode);
    }

    public static Optional<IErrorCode> lookup(String code){
        return Optional.ofNullable(errorCodeMap.get(code));
    }

    public static IErrorCode getOrDefault(String code, IErrorCode defailtErrorCode){
        return lookup(code).orElse(defailtErrorCode);
    }

    public static boolean isRegistered(String code){
        return errorCodeMap.containsKey(code);
    }

    public static Map<String, IErrorCode> getAllErrorCodes(){
        return new HashMap<>(errorCodeMap);
    }
}
