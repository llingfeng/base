package com.mode.agentmode.test;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * Created by admin on 2016/12/10.
 */
public class Proxy {

    public static Object newProxyInstance(Class infac, InvocationHandlerDemo handlerDemo) throws Exception {
        String rt = "\n\t";
        String methodStr = "";
        for (Method method : infac.getMethods()) {
            methodStr += "@Override" + rt +
                    "public void " + method.getName() + "() {" + rt +
                    "try{" + rt +
                    "Method md = " + infac.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt +
                    "handlerDemo.invoke(this,md);" + rt +
                    "}catch(NoSuchMethodException e){" + rt +
                    " e.printStackTrace();" + rt +
                    "}" + rt +
                    "}";
        }
        String str = "" +
                "package com.mode.agentmode;" + rt +
                "import com.mode.agentmode.test.InvocationHandlerDemo;" + rt +
                "import java.lang.reflect.Method;" + rt +
                "public class $Proxy0 implements " + infac.getName() + "{" + rt +
                "    private InvocationHandlerDemo handlerDemo;" + rt +
                "    public $Proxy0(InvocationHandlerDemo handlerDemo) {" + rt +
                "        this.handlerDemo = handlerDemo;" + rt +
                "    }" + rt +
                methodStr + rt +
                "}";

        //产生.java文件
        String filename = System.getProperty("user.dir") + "/out/production/javaio/com/mode/agentmode/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str, "utf-8");
        //编译
        //1.拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //2.得到文件管理者
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        //3.获得文件
        Iterable units = fileManager.getJavaFileObjects(filename);
        //4.编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        //5.进行编译
        t.call();

        //loader到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("com.mode.agentmode.$Proxy0");
        Constructor constructor = c.getConstructor(InvocationHandlerDemo.class);
        return constructor.newInstance(handlerDemo);
    }
}
