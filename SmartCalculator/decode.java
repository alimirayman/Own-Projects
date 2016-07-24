/**
 * Created by dexter on 7/21/16.
 */
public class decode {
    private double result;
    private List fix, dec;

    decode(postfix p, boolean angel){
        fix = p.fix;
        dec = new List();
        result = 0.0;

        while (!fix.isEmpty()){
            try {
                String op = (String) fix.pop();
                if (!isOperator(op)) {
                    dec.push(Double.parseDouble(op));
                }else{
                    double second,first;
                    second = (Double)dec.pop() ;

                    switch (op){
                        case "+":
                            first  = (Double)dec.pop();
                            result = first + second;
                            break;
                        case "-":
                            first  = (Double)dec.pop();
                            result = first - second;
                            break;
                        case "/":
                            first  = (Double)dec.pop();
                            result = first / second;
                            break;
                        case "*":
                        case "x":
                            first  = (Double)dec.pop();
                            result = first * second;
                            break;
                        case "^":
                            first  = (Double)dec.pop();
                            result = Math.pow(first,second);
                            break;
                        case "sin":
                            if(angel) result = Math.sin(Math.toRadians(second));
                            else result = Math.sin(second);
                            break;
                        case "cos":
                            if(angel) result = Math.cos(Math.toRadians(second));
                            else result = Math.cos(second);
                            break;
                        case "tan":
                            if(angel) result = Math.tan(Math.toRadians(second));
                            else result = Math.tan(second);
                            break;
                    }
                    dec.push(result);
                }
            }catch (StackUnderflowException e){
                System.out.println("Error");
            }
        }
        try {
            result = (Double)dec.pop();
        }catch (StackUnderflowException e){

        }
    }
    private boolean isOperator(String c){
        switch (c){
            case "+":
            case "-":
            case "/":
            case "*":
            case "x":
            case "^":
            case "sin":
            case "cos":
            case "tan":
                return true;
        }
        return false;
    }
    public double getResult(){
        return result;
    }

}
