package BridgeShow;

public class ShowAfterAbstraction extends ShowBridge {
	public ShowAfterAbstraction(Implementor imp)
	{
		super(imp);
	}

	@Override
	public void add() {
		imp.add();
	}
	
}
