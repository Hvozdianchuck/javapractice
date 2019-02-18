package advancedjava;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ExampleScript {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"/Test.java");
        System.out.println(result);
        ScriptEngineManager engineManager = new ScriptEngineManager();
       ScriptEngine scriptEngine= engineManager.getEngineByName("JavaScript");
   scriptEngine.put("n",4);
   String code = "print('hello');"+
           "var m = n+2";
   Object o = scriptEngine.eval(code);
        ((Invocable)scriptEngine).invokeFunction("name fuction","args");
        scriptEngine.get("m");
        System.out.println(o);
    }
}
