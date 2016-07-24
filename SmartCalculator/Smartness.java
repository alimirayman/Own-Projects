/**
 * Created by dexter on 7/25/16.
 */
public class Smartness {
    /**
     * chekes if the digit is valid in making double value or not
     * @param c a String of a single digit, minus or dot(.)
     * @return  true if it is a single digit, minus or dot(.) , false it not
     */
    protected boolean validDigit(String c){
        switch (c){
            case "1":case "2":case "3":case "4":case "5":
            case "6":case "7":case "8":case "9":case "0":
            case ".":case "-":
                return true;
        }
        return false;
    }

    /**
     * checks if the string is a operator or not
     * @param c a String mathematical operator
     * @return true if the string is a mathematical operator , false if not
     */
    protected boolean isOperator(String c){
        switch (c){
            case "+":
            case "-":
            case "/":
            case "*":
            case "x":
            case "^":
            case "(":
            case "{":
            case "[":
            case ")":
            case "}":
            case "]":
            case "sin":
            case "cos":
            case "tan":
                return true;
        }
        return false;
    }
    protected boolean isDOperator(String c){
        switch (c){
            case "sin":
            case "cos":
            case "tan":
            case "(":
            case "{":
            case "[":
            case ")":
            case "}":
            case "]":
                return true;
        }
        return false;
    }

    /**
     * lowest in hierarchy in POST-FIX method
     */
    protected boolean isPM(String c){
        switch (c){
            case "+":
            case "-":
                return true;
        }
        return false;
    }
    /**
     * middle in hierarchy in POST-FIX method
     */
    protected boolean isMD(String c){
        switch (c){
            case "/":
            case "*":
            case "x":
                return true;
        }
        return false;
    }
    /**
     * highest in hierarchy in POST-FIX method
     */
    protected boolean isSQ(String c){
        switch (c){
            case "^":
            case "sin":
            case "cos":
            case "tan":
                return true;
        }
        return false;
    }
    /**
     * Triangular operator
     */
    protected boolean isTRI(String c){
        switch (c){
            case "sin":
            case "cos":
            case "tan":
                return true;
        }
        return false;
    }
    /**
     * opening brackets
     */
    protected boolean isOB(String c){
        switch (c){
            case "(":
            case "{":
            case "[":
                return true;
        }
        return false;
    }
    /**
     * closing brackets
     */
    protected boolean isCB(String c){
        switch (c){
            case ")":
            case "}":
            case "]":
                return true;
        }
        return false;
    }
    /**
     * minus operator
     */
    protected boolean minus(String c){
        switch (c){
            case "-":
                return true;
        }
        return false;
    }
    protected boolean isTRIe(String c){
        switch (c){
            case "n":
            case "s":
                return true;
        }
        return false;
    }

    /**
     * This method takes a String and differentiate between operator and values by making space between them.
     * differentiate between negative operator and negative value
     * differentiate between normal brackets and brackets that are used for multiplication
     * @param user String that the user gives in equation text Field
     * @return
     */
    protected String properEQ(String user){
        String ret = "";
        String[] s = user.trim().split("");
        int i = 0;
        if(minus(s[i])){
            ret+= s[i];
            i++;
        }
        for(; i <s.length; i++){
            if(i != s.length-1 && minus(s[i])){
                if(isOperator(s[i-1]) && !isOperator(s[i+1]))
                    ret += " -";
                else if(!isOperator(s[i+1]))
                    ret += " + -";
                else
                    ret += " " + s[i] + " ";
            }
            else if(i != s.length-1 && i!=0 && isOB(s[i])){
                if((!isTRIe(s[i-1])) &&( (!isOperator(s[i-1])) || isCB(s[i-1]))) ret += " * "+s[i]+" ";
                else ret += " "+s[i]+" ";
            }else if(i != s.length-1 && i!=0 && isCB(s[i])){
                if((!isOperator(s[i+1]))) ret += " "+s[i]+" * ";
                else ret += " "+s[i]+" ";
            }
            else if(isOperator(s[i])){
                if(i == 0) ret += s[i] + " ";
                else ret += " " + s[i] + " ";
            }else {
                ret += s[i];
            }
        }
        return ret;
    }
}
