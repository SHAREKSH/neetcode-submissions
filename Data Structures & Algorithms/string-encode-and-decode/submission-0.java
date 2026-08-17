class Solution {
    public String encode(List<String> strs) {
        String op = "";
        for (String str : strs) {
            int length = str.length();
            op += length + "#" + str;
        }
        System.out.println(op);
        return op;
    }

    public List<String> decode(String str) {
        List<String> op = new ArrayList<>();
        int j = 0;

        while (j < str.length()) {
            String len="";
            while (str.charAt(j) != '#') {
                len += str.charAt(j);
                j++;
            }
            int length = Integer.parseInt(len);
            int range = j + length;
            String res = "";
            j++;
            while (j <= range) {
                res += str.charAt(j);
                j++;
            }
            op.add(res);
        }
        return op;
    }
}
