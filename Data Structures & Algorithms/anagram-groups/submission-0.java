class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    return generate(strs);
    }

    public static List<List<String>> generate(String[] arr) {

        Map<String, List<String>> map = new HashMap<>();

        for (String x : arr) {

            int[] key = new int[26];

            for (char ch : x.toCharArray()) {
                int index = ch - 'a';
                key[index] += 1;
            }

            String key_s = Arrays.toString(key);

            if (map.containsKey(key_s)) {

                List<String> abc = map.get(key_s);
                abc.add(x);
                map.put(key_s, abc);

            } else {

                List<String> internal = new ArrayList<>();
                internal.add(x);
                map.put(key_s, internal);
            }
        }

        List<List<String>> final_ = new ArrayList<>();

        for (List<String> op : map.values()) {
            final_.add(op);
        }

        return final_;
    }
}