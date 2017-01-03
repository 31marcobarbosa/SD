public class Mensagem{
	private String msg;

	public Mensagem(){
		msg = null;
	}

	synchronized public String getMsg() throws InterruptedException{
		while(msg == null)
			wait();

		String res = msg;
		msg = null;
		return res;
	}

	synchronized public void setMsg(String msg){
		this.msg = msg;
		notifyAll();
	}
}