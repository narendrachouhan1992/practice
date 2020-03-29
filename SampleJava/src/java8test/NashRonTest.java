package java8test;

import java.io.FileReader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashRonTest {
	public static void main(String[] args) throws Exception {
		// Creating script engine
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
		Bindings bind = ee.getBindings(ScriptContext.ENGINE_SCOPE);  
        bind.put("name", "Nashorn");  
		// Reading Nashorn file
		ee.eval(new FileReader("D:\\eclipse_new\\SampleJava\\src\\java8test\\hello.js"));
	}
}