package com.mode.agentmode;
	import com.mode.agentmode.test.InvocationHandlerDemo;
	import java.lang.reflect.Method;
	public class $Proxy0 implements com.mode.agentmode.Moveable{
	    private InvocationHandlerDemo handlerDemo;
	    public $Proxy0(InvocationHandlerDemo handlerDemo) {
	        this.handlerDemo = handlerDemo;
	    }
	@Override
	public void move() {
	try{
	Method md = com.mode.agentmode.Moveable.class.getMethod("move");
	handlerDemo.invoke(this,md);
	}catch(NoSuchMethodException e){
	 e.printStackTrace();
	}
	}
	}