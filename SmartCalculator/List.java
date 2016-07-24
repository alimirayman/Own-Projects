
public class List implements Stack{
    int size;
    Node top;


    public List(){
        size = 0;
        top = null;
    }


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}


	@Override
	public void push(Object e){
		// TODO Auto-generated method stub
//		if (size() == 5) throw new StackUnderflowException();
		top = new Node(e,top);
		size++;
	}


	@Override
	public Object pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (size() == 0) throw new StackUnderflowException();
		Object ret = top.val;
        top = top.next;
        size--;
		return ret;
	}


	@Override
	public Object peek() throws StackUnderflowException {
		// TODO Auto-generated method stub
        if (size() == 0) throw new StackUnderflowException();
        return top.val;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
        Object[] ret = new Object[size];
        int  i = 0;
        for ( Node n = top; n != null; n = n.next){
            ret[i++] = n.val;
        }
		return ret;
	}


	@Override
	public int search(Object e) {
		// TODO Auto-generated method stub
		int offset = 0;
        for ( Node n = top; n != null; n = n.next) {
            if (n.val == e) return offset;
            offset++;
        }
        return -1;
	}
	public void reverseList(){
		// TO DO
		Node Rev = null;
		for(Node n = this.top; n != null; n = n.next){
			Node m = new Node(n.val, null);
			m.next = Rev;
			Rev = m;
		}
        top = Rev;// please remove this line!
	}


}
