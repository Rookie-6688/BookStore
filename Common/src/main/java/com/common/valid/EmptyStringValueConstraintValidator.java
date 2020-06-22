package com.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class EmptyStringValueConstraintValidator implements ConstraintValidator<EmptyString, String> {

    private Set<Integer> set = new HashSet<>();

    //初始化方法，将满足条件的值放入Set容器中
    @Override
    public void initialize(EmptyString constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val : vals) {
            set.add(val);
        }
    }

    //判断是否校验成功
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null){
            return true;
        }else{
            if(s.length()==0){
                return false;
            }else{
                return true;
            }
        }
    }
}
