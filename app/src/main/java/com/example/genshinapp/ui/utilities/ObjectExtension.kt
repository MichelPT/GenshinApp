package com.example.genshinapp.ui.utilities

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.Composer
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.Modifier

fun findMethodByReflection(classMethod: Class<*>?, methodName: String): Method? {
    return try {
        if (!TextUtils.isEmpty(methodName)) {
            classMethod?.let { clazz ->
                clazz.methods.find { it.name.equals(methodName) && Modifier.isStatic(it.modifiers) }
            } ?: run {
                null
            }
        } else {
            null
        }
    }catch (e:Throwable){
        null
    }
}

fun loadClassByReflection(className: String): Class<*>? {
    return try {
        val classLoader = ::loadClassByReflection.javaClass.classLoader
        classLoader?.loadClass(className)
    } catch (e: Throwable) {
        null
    }
}

fun invokeMethod(method: Method, obj: Any, detailNavigation:(String)->Unit, composer: Composer): Boolean {
    return try {
        method.invoke(obj, detailNavigation, composer, 0)
        true
    } catch (e: InvocationTargetException) {
        // Handle InvocationTargetException
        Log.e("Method Invoker", "Error invoking method", e.targetException)
        false
    } catch (e: IllegalAccessException) {
        // Handle IllegalAccessException
        Log.e("Method Invoker", "Illegal access to method", e)
        false
    } catch (e: Throwable) {
        // Handle other exceptions
        Log.e("Method Invoker", "Error", e)
        false
    }
}