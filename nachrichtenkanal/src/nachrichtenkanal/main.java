package nachrichtenkanal;

import cs101.lang.AnimatorThread;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MyContainerJavaCollection kanal1 = new MyContainerJavaCollection();
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));
		AnimatorThread aniEmpf�nger = new AnimatorThread(new Empf�nger(kanal1));
		aniSender.startExecution();
		aniEmpf�nger.startExecution();
		aniEmpf�nger.setSleepRange(5000);	
		
	}

}
