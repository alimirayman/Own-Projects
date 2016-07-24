/**
 * Created by dexter on 7/21/16.
 */
public class checker extends Smartness{
    private String[] user;
    private boolean checked = true;
    private String errorM = "";
    checker(String user){
        this.user = properEQ(user).split("\\s+");

        if(!parenthesisMatch(user))checked = false;
        else {
            main:
            for (int i = 0; i < this.user.length; i++) {
                String cur = this.user[i];
                String next = "";
                if(i != this.user.length-1) next = this.user[i+1];
                if (isCB(cur) && i == this.user.length - 1) {
                    checked = true;
                }
                else if(isDOperator(cur)){
                    if ( i == this.user.length - 1) {
                        checked = false;
                        errorM = cur + " cannot be at the end.";
                        break;
                    }else if(isCB(next) && !isCB(cur)){
                        checked = false;
                        errorM = cur +" and " + next + " cannot be togather";
                        break ;
                    }
                }
                else if (isOperator(cur)) {
                    if (i == this.user.length - 1) {
                        checked = false;
                        errorM = cur + " cannot be at the end.";
                        break;
                    }
                    if (!(isDOperator(this.user[i + 1]) || !isOperator(this.user[i + 1]))) {
                        checked = false;
                        errorM = cur +" and " + next + " cannot be togather";
                        break;
                    }
                } else {
                    String[] v = cur.split("");
                    int count = 0;
                    for (String s : v) {
                        if (!validDigit(s)) {
                            checked = false;
                            errorM = "("+s+")Not valid Degit";
                            break main;
                        }
                        count++;
                    }
                }
            }
        }

    }
    public boolean isChecked(){
        return checked;
    }
    public String error(){
        return errorM;
    }



    /**
     * This method checks if the string equation has any parenthesis errors.
     * If the opening and closing brackets are set properly
     * @param input the string of equation that the user writes
     * @return true if the string has set the parenthesis properly, false if not
     */
    private boolean parenthesisMatch(String input){
        List brac = new List();
        List index = new List();
        String str = input;
        char[] user = str.toCharArray();
        int count = 0;
        boolean check = true;
        loop:
        for(char c : user){
            count++;
            switch (c){
                case '(':
                case '{':
                case '[':
                    brac.push(c);
                    index.push(count);
                    break;
                case ')':
                    try {
                        char b = (char)brac.pop();
                        int i = (int)index.pop();
                        if (b != '(') {
                            check = false;
                            errorM = i+". '"+b+"'- not closed ";
                            break loop;
                        }

                    }catch (StackUnderflowException e){
                        check = false;
                        errorM = count+". ')'- not opened ";
                        break loop;
                    }
                    break;
                case '}':
                    try {
                        char b = (char)brac.pop();
                        int i = (int)index.pop();
                        if (b != '{') {
                            check = false;
                            errorM = i+". '"+b+"'- not closed ";
                            break loop;
                        }

                    }catch (StackUnderflowException e){
                        check = false;
                        errorM = count+". '}'- not opened ";
                        break loop;
                    }
                    break;
                case ']':
                    try {
                        char b = (char)brac.pop();
                        int i = (int)index.pop();
                        if (b != '[') {
                            check = false;
                            errorM = i+". '"+b+"'- not closed ";
                            break loop;
                        }

                    }catch (StackUnderflowException e){
                        check = false;
                        errorM = count+". ']'- not opened ";
                        break loop;
                    }
                    break;

            }
        }
        if(!brac.isEmpty() && errorM.equals("")){
            try {
                check = false;
                char b = (char)brac.pop();
                int i = (int)index.pop();
                errorM = i+". '"+b+"'- not closed ";

            }catch (StackUnderflowException e){

            }
        }
        if (check && brac.isEmpty()){
            System.out.println("This expression is correct.");
            return true;
        }
        else{
            errorM = "Error at character # "+errorM;
            return false;
        }
    }


}
