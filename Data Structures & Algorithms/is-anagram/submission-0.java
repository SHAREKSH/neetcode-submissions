class Solution {
    public boolean isAnagram(String s, String t) {
        return check(s, t);
    }
    

public static boolean check(String input1, String input2){
if(input1.length()!=input2.length()) return false;
Map<Character, Integer> map=new HashMap<>();

for(char a: input1.toCharArray()){ map.put(a,map.getOrDefault(a,0)+1);

}

for(char a:input2.toCharArray()) {

if(!map.containsKey(a)) return false;

int val=map.get(a);

if(val==0) return false;

map.put(a,val-1);
}
return true;


}
}