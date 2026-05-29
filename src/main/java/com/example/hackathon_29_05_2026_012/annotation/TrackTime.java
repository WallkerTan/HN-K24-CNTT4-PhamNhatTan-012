package com.example.hackathon_29_05_2026_012.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // chỉ chạy trên method
@Retention(RetentionPolicy.RUNTIME) // chỉ tồn tại lúc runtime
public @interface TrackTime {

}
