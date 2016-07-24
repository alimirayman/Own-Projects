/**
 * Created by dexter on 7/21/16.
 */
public class postfix extends Smartness{
    private List operator;
    public List fix;
    private String[] user;
    postfix( String user){
        this.operator = new List();
        this.fix = new List();
        System.out.println(this.properEQ(user));
        this.user = this.properEQ(user).split("\\s+");
        for(String s: this.user){
            try{
                if(!isOperator(s)) fix.push(s);
                else if(operator.isEmpty()) operator.push(s);
                else{
                    String comp = (String) operator.peek();

                    if ( isPM(s) && ( isPM(comp) || isMD(comp) || isSQ(comp) ) ) {
                        fix.push(operator.pop());
                        if(isTRI(comp) && !operator.isEmpty()) fix.push(operator.pop());
                        operator.push(s);
                    }else if(isMD(s) && (isMD(comp) || isSQ(comp))){
                        fix.push(operator.pop());
                        operator.push(s);
                    }else if(isSQ(s) && isSQ(comp)){
                        fix.push(operator.pop());
                        operator.push(s);
                    }else if(isCB(s)){
                        String op  = (String) operator.peek();
                        while (!isOB(op)){
                            fix.push(operator.pop());
                            op = (String) operator.peek();
                        }
                        operator.pop();
                    }else {
                        operator.push(s);
                    }
                }

            }catch (StackUnderflowException e){

            }

        }

        while(!operator.isEmpty()){
            try{
                fix.push(operator.pop());
            }catch (StackUnderflowException e){

            }

        }
        fix.reverseList();
    }
}
