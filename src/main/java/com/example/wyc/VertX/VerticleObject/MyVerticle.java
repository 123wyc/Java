package com.example.wyc.VertX.VerticleObject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * @author wyc
 * @date 2020/6/10/15:33
 */
public class MyVerticle extends AbstractVerticle {

    /**
     * Vert.x其实就是建立了一个Verticle内部的线程安全机制，让用户可以排除多线程并发冲突的干扰，
     * 专注于业务逻辑上的实现，用了Vert.x，您就不用操心多线程和并发的问题了。
     * Verticle内部代码，除非声明Verticle是Worker Verticle，
     * 否则Verticle内部环境全部都是线程安全的，不会出现多个线程同时访问同一个Verticle内部代码的情况。
     */

    int i = 0;
    @Override
    public void start() throws Exception {

        this.vertx.createHttpServer().requestHandler(x->{
            System.out.println(">>>>>Hello world!<<<<<");
            x.response().putHeader("content-type", "text/plain").end("Hello world!");
        }).listen(6789);

        /**
         * Vert.x的Handler内部是atomic/原子操作，Verticle内部是thread safe/线程安全的，Verticle之间传递的数据是immutable/不可改变的。
         */
        this.vertx.createHttpServer().requestHandler(req->{
            i++;
            req.response().end();//要关闭请求，否则连接很快会被占满
        }).listen(6001);

        this.vertx.createHttpServer().requestHandler(req->{
            System.out.println(i);
            req.response().end(""+i);
        }).listen(6002);
    }

    public static void main(String[] args) {
        try{
            Vertx vertx = Vertx.vertx();
            vertx.deployVerticle(MyVerticle.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
