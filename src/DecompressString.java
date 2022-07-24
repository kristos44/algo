/**
 * https://techdevguide.withgoogle.com/resources/former-interview-question-compression-and-decompression/#
 */

public class DecompressString {

    private static StringBuilder sb;
    private static int index = 0;

    public static void main(String[] args) {
        String input = "y2[a]2[x2[z]]10[c]0[w]2[]";
//        String input = "2[ab]2[x2[iv]yz]c";
//        String input = "10[a]2[x2[]yz]c";
//        String input = "c2[2[a]z]c10[x]q";
//        String input = "c2[2[a]f]x";
//        String input = "1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[xx]]]]]]]]]]]]]]]]]]]]";
//        String input = "10[a]2[x2[]yz2[oi]]c0[b]";
//        String input = "a[]b";
//        String input = "0[abc]";

        sb = new StringBuilder();

        System.out.println(decompress(input));
    }

    private static String decompress(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                sb.append(input.charAt(i));
            } else if (Character.isDigit(input.charAt(i))) {
                sb.append(decompressNested(i, input));
                i = index;
            }
        }

        return sb.toString();
    }

    private static String decompressNested(int start, String input) {
        String timesStr = "";
        int times = 0;
        String tempOut = "";
        String output = "";
        boolean inMiddle = false;

        for (int i = start; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if (!inMiddle) {
                    timesStr += input.charAt(i);
                } else {
                    tempOut += decompressNested(i, input);
                    i = index;
                    inMiddle = false;
                }
            } else if (input.charAt(i) == '[') {
                times = Integer.parseInt(timesStr);
                inMiddle = true;
            } else if (Character.isLetter(input.charAt(i))) {
                tempOut += input.charAt(i);
                inMiddle = true;
            } else if (input.charAt(i) == ']') {
                for (int j = 0; j < times; j++) {
                    output += tempOut;
                }
                index = i;
                break;
            }
        }
        return output;
    }
}
