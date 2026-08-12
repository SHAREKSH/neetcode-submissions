class Solution {
    public int largestRectangleArea(int[] heights) {
    int[] left=LeftSmallest(heights);
    int[] right=RightSmallest(heights);
    int max_area=0;
   
    for (int i = 0; i < heights.length; i++) {
    int window=(right[i])-(left[i]+1);
    int Temp=heights[i]*window;
    if(Temp>max_area){
        max_area=Temp;

    }
    }

    return max_area;

    }

    public static int[] LeftSmallest(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] op = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            while (!s.isEmpty()) {
                if (arr[s.peek()] < arr[i]) {
                    op[i] = s.peek();
                    s.push(i);
                    break;
                } else {
                    s.pop();
                }
            }
            if (s.isEmpty()) {
 
                op[i] = -1;
                s.push(i);
            }
        }
    return op;

    }

    public static int[] RightSmallest(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] op = new int[arr.length];

        for (int i = arr.length-1; i >=0; i--) {

            while (!s.isEmpty()) {
                if (arr[s.peek()] < arr[i]) {
                    op[i] = s.peek();
                    s.push(i);
                    break;
                } else {
                    s.pop();
                }
            }
            if (s.isEmpty()) {
                // for easiness in window compuation
                op[i] = arr.length;
                s.push(i);
            }
            
        }
    return op;

    }

}