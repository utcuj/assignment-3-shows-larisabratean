package BridgeShow;

public class ShowAfterAbstraction extends ShowBridge {
	public ShowAfterAbstraction(Implementor imp)
	{
		super(imp);
	}

	@Override
	public void add(Show sh) {
		imp.add(sh);
	}
	
}
