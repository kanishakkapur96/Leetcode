class MovingAverage {
    int size;
    Queue<Integer> window = new LinkedList<>();
    int sum = 0;
    int count = 0;
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(count<size){
            window.offer(val);
            sum += val;
            count++;
            return (sum/(count*1.0));
        }else{
            sum = sum - window.poll();
            sum += val;
            window.offer(val);
            return (sum/(size*1.0));
        }
    
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */