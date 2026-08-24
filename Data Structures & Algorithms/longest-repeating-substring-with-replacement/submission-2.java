class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int len=s.length();
        int res=0;
        while(j<len){
           map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
           int max=0;
           int total=0;
           for(Character key:map.keySet()){
            int freq=map.get(key);
            total+=freq;
            max=Math.max(max,freq);
           }
           if((total-max)<=k){
            res=Math.max(res,j-i+1);
            j++;
           }else{
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            map.put(s.charAt(j),map.get(s.charAt(j))-1);
            i++;
           }
        }

    return res;
        
    }
}
