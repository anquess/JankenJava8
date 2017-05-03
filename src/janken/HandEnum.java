package janken;

public enum HandEnum{
	グー,チョキ,パー;
	public int judge(HandEnum hand){
		switch(this.ordinal() - hand.ordinal()){
		case 0:
			return 0;
		case -1:
		case 2:
			return 1;
		default:
			return -1;
		}
	}

}
