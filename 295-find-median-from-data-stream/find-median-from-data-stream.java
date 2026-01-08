class MedianFinder {

    Queue<Integer> lMaxHeap;
    Queue<Integer> rMinHeap;

    public MedianFinder() {
        lMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(rMinHeap.isEmpty()){
            rMinHeap.offer(num);
        }else if(lMaxHeap.isEmpty()){
            lMaxHeap.offer(num);
        }else{

            if(lMaxHeap.peek() >= num && rMinHeap.peek() > num){
                if(lMaxHeap.size() == rMinHeap.size()){
                    rMinHeap.offer(lMaxHeap.poll());
                   
                }
                 lMaxHeap.offer(num);

            }else{
                 if(rMinHeap.size()-1 == lMaxHeap.size()){
                    if(rMinHeap.peek() > num){
                      lMaxHeap.offer(num);
                    }else{
                        lMaxHeap.offer(rMinHeap.poll());
                        rMinHeap.offer(num);
                    }
                    
                 }else{
                    rMinHeap.offer(num);
                 }
                 
            }
            
        }

        if(lMaxHeap.size() == 1 && rMinHeap.size() ==1 && lMaxHeap.peek() > rMinHeap.peek()){
            int temp = lMaxHeap.poll();
            lMaxHeap.offer(rMinHeap.poll());
            rMinHeap.poll();
            rMinHeap.offer(temp);
        }

    }
    
    public double findMedian() {
        int size = lMaxHeap.size() + rMinHeap.size();
        if((size&1) == 1){
            return rMinHeap.peek();
        }

        return (rMinHeap.peek() + lMaxHeap.peek()) / 2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */