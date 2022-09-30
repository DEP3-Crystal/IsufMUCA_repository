
// checking characters using its ascii code

public class UserInput {
    public static class TextInput {
        protected String value = "";

        public void add(char c) {
            if ((((int) c) >= 65 && ((int) c) <= 90) || (((int) c) >= 97 && ((int) c) <= 122)) {
                value = value + c;
            }
        }

        public String getValue() {
            return value;
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if (!((((int) c) >= 65 && ((int) c) <= 90) || (((int) c) >= 97 && ((int) c) <= 122))) {
                value = value + c;
            }
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        //prints 10
        System.out.println(input.getValue());

        input=new TextInput();
        input.add('A');
        input.add('5');
        input.add('c');
        //prints Ac
        System.out.println(input.getValue());

    }
}
