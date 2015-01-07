package nachrichtenkanal;

import cs101.lang.AnimatorThread;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MyContainerJavaCollection kanal1 = new MyContainerJavaCollection();
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));
		AnimatorThread aniEmpfänger = new AnimatorThread(new Empfänger(kanal1));
		aniSender.startExecution();
		aniEmpfänger.startExecution();
		aniEmpfänger.setSleepRange(5000);	
		
	}

}
