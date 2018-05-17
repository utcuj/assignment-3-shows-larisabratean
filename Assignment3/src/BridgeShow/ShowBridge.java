package BridgeShow;

public abstract class ShowBridge {
	protected Implementor imp;
	protected  ShowBridge (Implementor imp)
	{
		this.imp=imp;
	}
	public abstract void add(Show sh);
}
