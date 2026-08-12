class Solution {
    public String longestCommonPrefix(String[] strs) {
        
    String candidate=strs[0];
    
    for(int i=1;i<strs.length;i++){
        String checked="";
        if(strs[i].equals("")) return "";
        for(int j=0;j<Math.min(candidate.length(),strs[i].length());j++){
        if(candidate.charAt(j)==strs[i].charAt(j)){
          checked+=candidate.charAt(j);
        }else{
            candidate=checked;
            break;
        }
        
        }
        candidate=checked;
        if(candidate.equals("")) return candidate;
    }
    return candidate;
    }
}