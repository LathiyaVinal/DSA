class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class Compute 
{
    static pair getMinMax(long nums[], long n)  
    {
        
        pair pair = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
     
        if(n == 1){
            pair.first = 0;
            pair.second = 0;
        }else{
            
            pair.first = Math.min(nums[0], nums[1]);
            pair.second = Math.max(nums[0], nums[1]);
            
            for(int i = 2 ; i < n ; i++){
                pair.first = Math.min(nums[i],  pair.first);
                pair.second = Math.max(nums[i], pair.second);
                 
            }
        }
        
        return pair;
        
    }
}
