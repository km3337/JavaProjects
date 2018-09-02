public abstract class Window implements GUIComponent {

	//fields
	int width, height;
	boolean visible=false, minimized=false;
	
	//methods
	public Window(int width,int height) 
	{
		this.width=width;
		this.height=height;
	}


	public void display() {
		if (!(this.isVisible())) {
			System.out.println("(Nothing to see here)");
		}
		else 
		if(this.minimized) 
		{
			System.out.println("["+this+ " (minimized)]");
		}
		else displayNormal();
	}

	
	public void setVisible(boolean truthValue) {
		this.visible=truthValue;
	}

	public boolean isVisible() {
		return this.visible;
	}
	
	public void resize(int width, int height) 
	{
		this.width=width;
		this.height=height;
	}
	
	public void minimize() 
	{
		this.minimized=true;
	}
	
	public void restore() {
		this.minimized=false;
	}
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public abstract void displayNormal();
	

}
