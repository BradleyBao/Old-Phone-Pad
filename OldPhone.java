package CodeChallenge;

public class OldPhone {

    public static void main(String[] args) {
        System.out.println(OldPhonePad("4433555 555666#"));
        System.out.println(OldPhonePad("33#"));
        System.out.println(OldPhonePad("227*#"));
        System.out.println(OldPhonePad("8 88777444666*664#"));
        System.out.println(OldPhonePad("7777339992#"));
    }

    public static String OldPhonePad(String input) {
        String[][] menu = {
                {"&", "'", "("},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"},
        };
        String[] split_str = input.split(" ");
        StringBuilder answer = new StringBuilder();
        for (String each : split_str) {
            String[] each_nums = each.split("");
            String latest = each_nums[0];
            int index = 0;

            for (int i = 0; i < each_nums.length; i++) {
                String each_num = each_nums[i];
                if (each_num.equals(latest)) {
                    index++;

                    if (i == each_nums.length - 1 && !each_num.equals("#")) {
                        answer.append(menu[Integer.parseInt(latest) - 1][(index - 1) % menu[Integer.parseInt(latest)].length]);
                    }

                } else {
                    if (index != 0) answer.append(menu[Integer.parseInt(latest) - 1][(index - 1) % menu[Integer.parseInt(latest) - 1].length]);
                    if (each_num.equals("*")) {
                        answer.setLength(answer.length() - 1);
                        index = 0;
                    } else if(each_num.equals("#")) {
                        return answer.toString();
                    } else {
                        latest = each_num;
                        index = 1;
                    }
                }
            }
        }
        return answer.toString();
    }
}
