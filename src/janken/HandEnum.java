package janken;

public enum HandEnum{
	GU{
		public int judge(HandEnum hand){
			switch(hand){
			case GU :
				return 0;
			case CHOKI:
				return 1;
			default:
				return -1;}
			}
	},CHOKI,PAH;
	public int judge(HandEnum hand){return 0;};

}
