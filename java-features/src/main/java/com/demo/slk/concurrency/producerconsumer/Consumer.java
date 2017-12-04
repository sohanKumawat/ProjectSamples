package com.demo.slk.concurrency.producerconsumer;

import java.util.concurrent.BlockingQueue;
//kafka consume https://www.safaribooksonline.com/library/view/kafka-the-definitive/9781491936153/ch04.html
class Consumer implements Runnable{

    @SuppressWarnings("rawtypes")
	private final BlockingQueue sharedQueue;

    @SuppressWarnings("rawtypes")
	public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
            	
                System.out.println("sharedQueue size "+sharedQueue.size()+"Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
               // Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


