package com.example.wyc.DesignPatterns.link;



/**
 * 定义一个抽象的handle
 * @author wyc
 *
 */
public abstract class Handler {

	/**
	 *  //指向下一个处理者
	 */
	private Handler nextHandler;
	/**
	 * //处理者能够处理的级别
	 */
	private int level;

	public Handler(int level) {
		this.level = level;
	}

	public void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}

	/**
	 * // 处理请求传递，注意final，子类不可重写
	 * @param request
	 */
	public final void handleMessage(Request request) {
		//        if (level == request.getRequestLevel()) {
		//            this.echo(request);
		//        } else {
		//            if (this.nextHandler != null) {
		//                this.nextHandler.handleMessage(request);
		//            } else {
		//                System.out.println("已经到最尽头了");
		//            }
		//        }
		this.echo(request);
		if (this.nextHandler != null) {
			this.nextHandler.handleMessage(request);
		} else {
			System.out.println("已经到最尽头了");
		}
	}


	// 抽象方法，子类实现
	public abstract void echo(Request request);
}
